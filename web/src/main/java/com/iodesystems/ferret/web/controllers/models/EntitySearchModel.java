package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.web.models.Page;

public class EntitySearchModel extends Page {

    private String query;
    private Integer offset;
    private Integer limit;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
