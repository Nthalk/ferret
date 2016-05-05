package com.iodesystems.ferret.web.models;

public class Breadcrumb {
    private String href;
    private String label;

    public Breadcrumb(String href, String label) {
        this.href = href;
        this.label = label;
    }

    public Breadcrumb() {
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
