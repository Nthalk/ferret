package com.iodesystems.ferret.web.models;

import java.util.ArrayList;
import java.util.List;

public class Sidebar {
    private List<MenuGroup> menuGroups = new ArrayList<MenuGroup>();

    public List<MenuGroup> getMenuGroups() {
        return menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }
}
