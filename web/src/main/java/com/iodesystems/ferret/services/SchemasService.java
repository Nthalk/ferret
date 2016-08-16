package com.iodesystems.ferret.services;

import com.iodesystems.ferret.db.tables.records.SchemaRecord;
import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.models.Schema;
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

import static com.iodesystems.ferret.db.Tables.SCHEMA;
import static com.iodesystems.ferret.db.Tables.TABLE;

@Component
public class SchemasService {
    @Autowired
    PageFactory pageFactory;

    @Autowired
    DSLContext db;

    private Field<Integer> TABLE_COUNT = DSL.selectCount().from(TABLE).where(TABLE.SCHEMA_ID.eq(SCHEMA.ID)).asField();

    public Page<Schema> find(DataSource dataSource, PageRequest pageRequest) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(SCHEMA.DATA_SOURCE_ID.equal(dataSource.getId()));
        return pageFactory
            .from(pageRequest, query)
            .convertAndBuild(getMapper());
    }

    private From<Record, Schema> getMapper() {
        return r -> {
            Schema schema = new Schema();
            schema.setId(r.get(SCHEMA.ID));
            schema.setName(r.get(SCHEMA.NAME));
            schema.setDataSourceId(r.get(SCHEMA.DATA_SOURCE_ID));
            schema.setTableCount(r.get(TABLE_COUNT));
            return schema;
        };
    }

    private SelectQuery<Record> getQuery() {
        SelectQuery<Record> query = db.selectQuery();
        query.addFrom(SCHEMA);
        query.addSelect(SCHEMA.NAME);
        query.addSelect(SCHEMA.ID);
        query.addSelect(SCHEMA.DATA_SOURCE_ID);
        query.addSelect(TABLE_COUNT);
        return query;
    }

    public void create(Schema schema) {
        SchemaRecord schemaRecord = db.newRecord(SCHEMA);
        schemaRecord.setName(schema.getName());
        schemaRecord.setDataSourceId(schema.getDataSourceId());
        schemaRecord.insert();
    }

    public Schema findById(Integer id) {
        SelectQuery<Record> query = getQuery();
        query.addConditions(SCHEMA.ID.equal(id));
        return getMapper().from(query.fetchOne());
    }
}
