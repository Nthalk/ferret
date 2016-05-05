package com.iodesystems.ferret.data.definition;

import com.iodesystems.ferret.data.Entity;
import com.iodesystems.ferret.data.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityDefinition {
    private String name;
    private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();
    private String title;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldDefinition> getFieldDefinitions() {
        return fieldDefinitions;
    }

    public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
        this.fieldDefinitions = fieldDefinitions;
    }

    public Entity create() {
        return new Entity(this);
    }

    public Map<String, Field> createFields() {
        HashMap<String, Field> fields = new HashMap<String, Field>();
        for (FieldDefinition fieldDefinition : fieldDefinitions) {
            fields.put(fieldDefinition.getName(), fieldDefinition.create());
        }
        return fields;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
