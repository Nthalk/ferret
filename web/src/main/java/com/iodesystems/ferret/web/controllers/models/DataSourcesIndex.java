package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.DataSource;
import com.iodesystems.ferret.query.Page;

public class DataSourcesIndex {
    private Page<DataSource> dataSources;

    public void setDataSources(Page<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public Page<DataSource> getDataSources() {
        return dataSources;
    }
}
