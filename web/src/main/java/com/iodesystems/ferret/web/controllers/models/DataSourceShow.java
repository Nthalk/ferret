package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.query.Page;

public class DataSourceShow {
    private DataSource dataSource;
    private Page<Schema> schemas;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setSchemas(Page<Schema> schemas) {
        this.schemas = schemas;
    }

    public Page<Schema> getSchemas() {
        return schemas;
    }
}
