package com.iodesystems.ferret.data.definition;

import com.iodesystems.ferret.data.Field;

public class FieldDefinition {

    private String name;
    private String description;
    private FieldTypeDefinition typeDefinition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field create() {
        return new Field(this);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public FieldTypeDefinition getTypeDefinition() {
        return typeDefinition;
    }

    public void setTypeDefinition(FieldTypeDefinition typeDefinition) {
        this.typeDefinition = typeDefinition;
    }
}
