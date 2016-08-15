package com.iodesystems.ferret.query;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageFactory {
    @Autowired
    DSLContext db;

    public <R extends Record> PageBuilder<R, R> from(PageRequest pageRequest, SelectQuery<R> source) {
        return new PageBuilder<R, R>(db, source).page(pageRequest);
    }
}
