package com.iodesystems.ferret.query;

public class PageRequest {

    private int perPage = 15;
    private int page = 1;

    public PageRequest(Integer page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStart() {
        return (getPage() - 1) * getPerPage();
    }

    public int getEnd() {
        return getStart() + getStart() + getPerPage();
    }
}
