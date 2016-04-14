package com.iodesystems.ferret.web.models;

import com.iodesystems.ferret.web.models.components.Text;

public class Paragraph extends Text {
    public Paragraph(String content) {
        super(content);
    }

    @Override
    public String getType() {
        return "paragraph";
    }
}
