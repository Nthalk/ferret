package com.iodesystems.ferret.web.models;

import com.iodesystems.ferret.web.models.components.Section;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

public class Page extends Section {
    private String title;
    private List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
    private List<Component> components = new ArrayList<Component>();
    private Navigation navigation;
    private Sidebar sidebar;

    private final Errors errrors = new DirectFieldBindingResult(this, "entityIndexModel");

    public Errors getErrrors() {
        return errrors;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public void setNavigation(Navigation navigation) {
        this.navigation = navigation;
    }

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

    public void setSidebar(Sidebar sidebar) {
        this.sidebar = sidebar;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }
}
