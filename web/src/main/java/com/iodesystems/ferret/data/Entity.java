package com.iodesystems.ferret.data;

import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.fn.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Entity implements Kind {

    private final EntityDefinition entityDefinition;
    private final Map<String, Field> fields;

    public Entity(EntityDefinition entityDefinition) {
        this.entityDefinition = entityDefinition;
        fields = entityDefinition.createFields();
    }


    @Override
    public List<Field> getFields() {
        List<Field> fields = new ArrayList<Field>();
        fields.addAll(this.fields.values());
        return fields;
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
