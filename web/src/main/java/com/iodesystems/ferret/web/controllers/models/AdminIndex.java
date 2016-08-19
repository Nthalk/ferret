package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.DataSourceReference;
import com.iodesystems.ferret.models.NavTree;

import java.util.List;

public class AdminIndex {
    private List<DataSourceReference> dataSourceReferences;
    private NavTree navTree;

    public void setDataSourceReferences(List<DataSourceReference> dataSourceReferences) {
        this.dataSourceReferences = dataSourceReferences;
    }

    public List<DataSourceReference> getDataSourceReferences() {
        return dataSourceReferences;
    }

    public void setNavTree(NavTree navTree) {
        this.navTree = navTree;
    }

    public NavTree getNavTree() {
        return navTree;
    }
}
