package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;

public class Text implements Component {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public Text() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getType() {
        return "text";
    }
}
