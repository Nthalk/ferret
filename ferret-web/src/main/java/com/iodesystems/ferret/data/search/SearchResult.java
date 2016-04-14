package com.iodesystems.ferret.data.search;

import com.iodesystems.ferret.data.Entity;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private List<Entity> data = new ArrayList<Entity>();
    private Integer offset;
    private Integer totalCount;
    private Integer total;
    private String query;

    public List<Entity> getData() {
        return data;
    }

    public void setData(List<Entity> data) {
        this.data = data;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
