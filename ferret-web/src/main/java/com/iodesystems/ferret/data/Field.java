package com.iodesystems.ferret.data;

import com.iodesystems.ferret.data.definition.FieldDefinition;

public class Field {
    private final FieldDefinition fieldDefinition;
    private Object value;

    public Field(FieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
