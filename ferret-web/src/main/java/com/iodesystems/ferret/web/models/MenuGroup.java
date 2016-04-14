package com.iodesystems.ferret.web.models;

import java.util.ArrayList;
import java.util.List;

public class MenuGroup {
    private final String title;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public MenuGroup(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
