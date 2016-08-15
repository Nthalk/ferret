package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.models.Table;
import com.iodesystems.ferret.query.Page;

public class SchemaShow {
    private Schema schema;
    private Page<Table> tables;

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setTables(Page<Table> tables) {
        this.tables = tables;
    }

    public Page<Table> getTables() {
        return tables;
    }
}
