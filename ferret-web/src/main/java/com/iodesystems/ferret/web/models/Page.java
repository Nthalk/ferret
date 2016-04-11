package com.iodesystems.ferret.web.models;

import com.iodesystems.ferret.web.models.components.Section;

import java.util.ArrayList;
import java.util.List;

public class Page extends Section {
    private String title;
    private List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
    private List<Component> components = new ArrayList<Component>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
