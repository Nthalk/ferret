package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.DataSource;

import javax.validation.Valid;

public class DataSourceCreate {
    private DataSource dataSource;

    @Valid
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
