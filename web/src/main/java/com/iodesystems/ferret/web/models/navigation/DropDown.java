package com.iodesystems.ferret.web.models.navigation;

import com.iodesystems.ferret.web.models.components.Link;

import java.util.ArrayList;
import java.util.List;

public class DropDown {
    private String title;
    private String icon;
    private List<Link> links = new ArrayList<Link>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public String getTitle() {
        return title;
    }

    public List<Link> getLinks() {
        return links;
    }
}
