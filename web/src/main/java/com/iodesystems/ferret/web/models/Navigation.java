package com.iodesystems.ferret.web.models;

import com.iodesystems.ferret.web.models.navigation.DropDown;

import java.util.ArrayList;
import java.util.List;

public class Navigation {
    private String title;
    private List<DropDown> dropDowns = new ArrayList<DropDown>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addDropDown(DropDown dropDown) {
        dropDowns.add(dropDown);
    }

    public List<DropDown> getDropDowns() {
        return dropDowns;
    }
}
