package com.iodesystems.ferret.web.models;

import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType()
public class MenuGroup {
    private String title;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public MenuGroup() {
    }

    public MenuGroup(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        getMenuItems().add(menuItem);
    }
}
