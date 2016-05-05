package com.iodesystems.ferret.web.models;

public class MenuItem {
    private String label;
    private String href;

    public MenuItem(String href, String label) {
        this.href = href;
        this.label = label;
    }

    public MenuItem() {
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getHref() {
        return href;
    }
}