package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.models.Schema;

public class DataSourceAddSchema {
    private DataSource dataSource;
    private Schema schema;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public Schema getSchema() {
        return schema;
    }
}
