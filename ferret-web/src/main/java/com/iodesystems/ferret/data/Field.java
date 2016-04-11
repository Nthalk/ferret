package com.iodesystems.ferret.data;

import com.iodesystems.ferret.data.definition.FieldDefinition;

public class Field {
    private final FieldDefinition fieldDefinition;
    private String value;

    public Field(FieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
