package com.iodesystems.ferret.query;

import com.iodesystems.fn.data.From;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

public class PageBuilder<R extends Record, S> {
    private final DSLContext db;
    private final SelectQuery<R> items;
    private Condition condition;
    private List<From<R, S>> converter = new ArrayList<>();
    private PageRequest page;

    PageBuilder(DSLContext db, SelectQuery<R> items) {
        this.db = db;
        this.items = items;
    }

    public PageBuilder<R, S> page(PageRequest pageRequest) {
        this.page = pageRequest;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> PageBuilder<R, T> convert(From<S, T> from) {
        converter.add((From<R, S>) from);
        return (PageBuilder<R, T>) this;
    }


    public PageBuilder<R, S> where(Condition condition) {
        this.condition = condition;
        return this;
    }

    public Page<S> build() {
        int totalCount = db.selectCount().from(items).fetchOne(DSL.count());
        List<S> results;
        int resultCount;
        if (condition != null) {
            SelectConditionStep<R> filteredQuery = db.selectFrom(items.asTable()).where(condition);
            resultCount = db.selectCount().from(filteredQuery).fetchOne(DSL.count());
            results = filteredQuery.limit(page.getStart(), page.getPerPage()).fetch(r -> {
                Object t = r;
                for (From<R, S> convert : converter) {
                    t = convert.from((R) t);
                }
                return (S) t;
            });
        } else {
            items.addLimit(page.getStart(), page.getPerPage());
            results = items.fetch(r -> {
                Object t = r;
                for (From<R, S> convert : converter) {
                    t = convert.from((R) t);
                }
                return (S) t;
            });
            resultCount = totalCount;
        }
        return new Page<>(results, totalCount, resultCount, page);
    }

    public <T> Page<T> convertAndBuild(From<S, T> mapper) {
        return convert(mapper).build();
    }
}
