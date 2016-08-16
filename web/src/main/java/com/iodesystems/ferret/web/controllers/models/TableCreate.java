package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.models.Table;

public class TableCreate {
    private Schema schema;
    private Table table;

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}
