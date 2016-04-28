package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;

public class Input extends Component {
    private String label;
    private Boolean required;
    private String placeholder;

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
}
