package com.iodesystems.ferret.web.models.components.grid;

import com.iodesystems.ferret.web.models.Component;
import com.iodesystems.ferret.web.models.NestedComponent;

public class GridColumn extends NestedComponent{
    private int width;
    private int offset;

    @Override
    public String getType() {
        return "column";
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
