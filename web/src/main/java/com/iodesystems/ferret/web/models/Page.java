package com.iodesystems.ferret.web.models;

import com.iodesystems.ferret.web.models.components.Section;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.Errors;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "Page", namespace = "http://iodesystems.com")
public class Page extends Section {
    private final Errors errors = new DirectFieldBindingResult(this, "entityIndexModel");
    private String title;
    private List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
    private Navigation navigation;
    private Sidebar sidebar = new Sidebar();

    public Errors getErrors() {
        return errors;
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

    public Sidebar getSidebar() {
        return sidebar;
    }

    public void setSidebar(Sidebar sidebar) {
        this.sidebar = sidebar;
    }
}
