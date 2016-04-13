package com.iodesystems.ferret.web.models.components.table;

import com.iodesystems.ferret.web.models.Component;

public class ColumnHeader{
    private final Component content;

    public ColumnHeader(Component content) {
        this.content = content;
    }

    public Component getContent() {
        return content;
    }
}
