package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;

public class Link implements Component {
    private String text;
    private String href;
    private String icon;

    public Link(String text) {
        this.text = text;
    }

    public Link() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getType() {
        return "link";
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
