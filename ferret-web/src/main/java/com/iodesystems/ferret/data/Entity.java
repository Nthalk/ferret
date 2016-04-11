package com.iodesystems.ferret.data;

import com.iodesystems.fn.Option;
import com.iodesystems.ferret.data.definition.EntityDefinition;

import java.util.Collection;
import java.util.Map;

public class Entity implements Kind {

    private final EntityDefinition entityDefinition;
    private final Map<String, Field> fields;

    public Entity(EntityDefinition entityDefinition) {
        this.entityDefinition = entityDefinition;
        fields = entityDefinition.createFields();
    }


    @Override
    public Collection<Field> getFields() {
        return fields.values();
    }

    @Override
    public Option<Field> getField(String name) {
        if (fields.containsKey(name)) {
            return Option.of(fields.get(name));
        } else {
            return Option.empty();
        }
    }
}
