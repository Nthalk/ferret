package com.iodesystems.ferret.services;

import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.models.DataSourceReference;
import com.iodesystems.ferret.query.Page;
import com.iodesystems.ferret.query.PageFactory;
import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.fn.data.From;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.iodesystems.ferret.db.Tables.DATA_SOURCE;
import static com.iodesystems.ferret.db.Tables.SCHEMA;

@Component
public class DataSourcesService {
    @Autowired
    DSLContext db;

    @Autowired
    PageFactory pageFactory;

    private Field<Integer> schemaCount = DSL.selectCount().from(SCHEMA).where(SCHEMA.DATA_SOURCE_ID.equal(DATA_SOURCE.ID)).asField();
    private From<Record, DataSource> mapper = r -> {
        DataSource d = new DataSource();
        d.setId(r.get(DATA_SOURCE.ID));
        d.setName(r.get(DATA_SOURCE.NAME));
        d.setSchemaCount(r.get(schemaCount));
        return d;
    };

    private SelectQuery<Record> getQuery() {
        SelectQuery<Record> query = db.selectQuery();
        query.addFrom(DATA_SOURCE);
        query.addSelect(DATA_SOURCE.ID);
        query.addSelect(DATA_SOURCE.NAME);
        query.addSelect(schemaCount);
        return query;
    }

    public Page<DataSource> find(PageRequest page) {
        return pageFactory
            .from(page, getQuery())
            .convertAndBuild(mapper);
    }

    public DataSource findById(int id) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(DATA_SOURCE.ID.equal(id));
        return mapper.from(query.fetchOne());
    }

    public DataSource create(DataSource dataSource) {
        return findById(
            db.insertInto(DATA_SOURCE)
                .set(DATA_SOURCE.NAME, dataSource.getName())
                .returning()
                .fetchOne().getId());
    }

    public List<DataSourceReference> findAllReferences() {
        return db
            .select(DATA_SOURCE.ID, DATA_SOURCE.NAME)
            .from(DATA_SOURCE)
            .fetch(r -> new DataSourceReference(r.get(DATA_SOURCE.ID), r.get(DATA_SOURCE.NAME)));
    }
}
