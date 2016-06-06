package com.iodesystems.ferret.web.models.components.form;

import com.iodesystems.ferret.web.models.Component;

public class Label implements Component {
    private String text;
    private Boolean required;

    @Override
    public String getType() {
        return "form/label";
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
