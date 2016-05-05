package com.iodesystems.ferret.conf;

import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.definition.FieldDefinition;
import com.iodesystems.ferret.data.definition.FieldTypeDefinition;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class Configuration {
    private List<DataSourceConfiguration> dataSourceConfigurations = new ArrayList<DataSourceConfiguration>();
    private List<EntityDefinition> entityDefinitions = new ArrayList<EntityDefinition>();
    private List<FieldTypeDefinition> fieldTypeDefinitions = new ArrayList<FieldTypeDefinition>();

    public List<FieldTypeDefinition> getFieldTypeDefinitions() {
        fieldTypeDefinitions.clear();

        FieldTypeDefinition integer = new FieldTypeDefinition();
        integer.setName("integer");
        fieldTypeDefinitions.add(integer);

        return fieldTypeDefinitions;
    }

    public FieldTypeDefinition getFieldTypeDefinition(String name) {
        for (FieldTypeDefinition fieldTypeDefinition : getFieldTypeDefinitions()) {
            if (fieldTypeDefinition.getName().equals(name)) {
                return fieldTypeDefinition;
            }
        }
        throw new NoSuchElementException();
    }

    public void setFieldTypeDefinitions(List<FieldTypeDefinition> fieldTypeDefinitions) {
        this.fieldTypeDefinitions = fieldTypeDefinitions;
    }

    public List<DataSourceConfiguration> getDataSourceConfigurations() {
        return dataSourceConfigurations;
    }

    public void setDataSourceConfigurations(List<DataSourceConfiguration> dataSourceConfigurations) {
        this.dataSourceConfigurations = dataSourceConfigurations;
    }

    public List<EntityDefinition> getEntityDefinitions() {
        entityDefinitions.clear();

        // Define the asset
        EntityDefinition assets = new EntityDefinition();
        assets.setName("assets");
        assets.setTitle("Assets");
        assets.setDescription("Things that have value");

        FieldDefinition id = new FieldDefinition();
        id.setName("id");
        id.setDescription("Unique identifier");
        id.setTypeDefinition(getFieldTypeDefinition("integer"));
        assets.getFieldDefinitions().add(id);
        entityDefinitions.add(assets);

        EntityDefinition shipments = new EntityDefinition();
        shipments.setName("shipments");
        shipments.setTitle("Shipments");

        shipments.getFieldDefinitions().add(id);
        entityDefinitions.add(shipments);


        return entityDefinitions;
    }

    public void setEntityDefinitions(List<EntityDefinition> entityDefinitions) {
        this.entityDefinitions = entityDefinitions;
    }

}
