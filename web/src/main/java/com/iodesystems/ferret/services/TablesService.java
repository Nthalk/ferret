package com.iodesystems.ferret.services;

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

import static com.iodesystems.ferret.db.Tables.TABLE;

@Component
public class TablesService {
    @Autowired
    DSLContext db;

    @Autowired
    PageFactory pageFactory;

    private From<Record, Table> mapper = r -> {
        Table t = new Table();
        t.setId(r.get(TABLE.ID));
        t.setName(r.get(TABLE.NAME));
        return t;
    };

    private SelectQuery<Record> getQuery() {
        SelectQuery<Record> query = db.selectQuery();
        query.addFrom(TABLE);
        query.addSelect(TABLE.ID);
        query.addSelect(TABLE.NAME);
        return query;
    }

    public Page<Table> find(Schema schema, PageRequest page) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(TABLE.SCHEMA_ID.equal(schema.getId()));
        return pageFactory
            .from(page, query)
            .convertAndBuild(mapper);
    }

    public Table findById(int id) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(TABLE.ID.equal(id));
        return mapper.from(query.fetchOne());
    }

    public Table create(Table table) {
        return mapper.from(
            db.insertInto(TABLE)
                .set(TABLE.SCHEMA_ID, table.getSchemaId())
                .set(TABLE.NAME, table.getName())
                .returning()
                .fetchOne());
    }
}
