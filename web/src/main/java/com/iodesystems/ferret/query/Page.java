package com.iodesystems.ferret.query;

import java.util.List;

public class Page<T> extends PageRequest {

    private final List<T> items;
    private final int totalCount;
    private final int resultCount;

    public Page(List<T> items, int totalCount, int resultCount, PageRequest pageRequest) {
        super(pageRequest.getPage());
        this.items = items;
        this.totalCount = totalCount;
        this.resultCount = resultCount;
        setPerPage(pageRequest.getPerPage());
    }

    public List<T> getItems() {
        return items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getResultCount() {
        return resultCount;
    }

    public int getEnd() {
        return getStart() + items.size();
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) resultCount / getPerPage());
    }
}
