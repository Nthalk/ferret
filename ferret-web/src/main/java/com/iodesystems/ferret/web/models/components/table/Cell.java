package com.iodesystems.ferret.web.models.components.table;

import com.iodesystems.ferret.web.models.Component;

public class Cell {

    private Component content;

    public Cell(Component content) {
        this.content = content;
    }

    public Component getContent() {
        return content;
    }

    public void setContent(Component content) {
        this.content = content;
    }
}
