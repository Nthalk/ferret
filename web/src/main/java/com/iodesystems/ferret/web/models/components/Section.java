package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.NestedComponent;

public class Section extends NestedComponent {

    private String title;
    private String subTitle;

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getType() {
        return "section";
    }
}
