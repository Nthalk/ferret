package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.web.models.Page;

import java.util.List;

public class EntitiesIndexModel extends Page {
    private List<EntityDefinition> entityDefinitions;

    public void setEntityDefinitions(List<EntityDefinition> entityDefinitions) {
        this.entityDefinitions = entityDefinitions;
    }

    public List<EntityDefinition> getEntityDefinitions() {
        return entityDefinitions;
    }
}
