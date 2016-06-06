package com.iodesystems.ferret.web.models.components.form;

import com.iodesystems.ferret.web.models.Component;

public class Input implements Component {
    private String label;
    private Boolean required;
    private String placeholder;
    private String name;
    private String value;

    @Override
    public String getType() {
        return "form/input";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
