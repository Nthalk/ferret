package com.iodesystems.ferret.data.definition;

import java.util.ArrayList;
import java.util.List;

public class KindDefinition {
    private String name;
    private List<FieldDefinition> fields = new ArrayList<FieldDefinition>();

    public List<FieldDefinition> getFields() {
        return fields;
    }

    public void setFields(List<FieldDefinition> fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
