package com.iodesystems.ferret.data.definition;

import com.iodesystems.ferret.data.Field;

public class FieldDefinition {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field create() {
        return new Field(this);
    }
}
