package com.iodesystems.ferret.services;

import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.models.Field;
import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.models.Table;
import com.iodesystems.ferret.query.Page;
import com.iodesystems.ferret.query.PageFactory;
import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.fn.data.From;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.iodesystems.ferret.db.Tables.FIELD;

@Component
public class FieldsService {
    @Autowired
    DSLContext db;

    @Autowired
    PageFactory pageFactory;

    private From<Record, Field> mapper = r -> {
        Field d = new Field();
        d.setId(r.get(FIELD.ID));
        d.setName(r.get(FIELD.NAME));
        return d;
    };

    private SelectQuery<Record> getQuery() {
        SelectQuery<Record> query = db.selectQuery();
        query.addFrom(FIELD);
        query.addSelect(FIELD.ID);
        query.addSelect(FIELD.NAME);
        return query;
    }

    public Page<Field> find(Table table, PageRequest page) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(FIELD.TABLE_ID.equal(table.getId()));
        return pageFactory
            .from(page, query)
            .convertAndBuild(mapper);
    }

    public Field findById(int id) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(FIELD.ID.equal(id));
        return mapper.from(query.fetchOne());
    }
}
