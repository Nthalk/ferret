package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.query.Page;

public class SchemasIndex {
    private Page<Schema> schemas;

    public void setSchemas(Page<Schema> schemas) {
        this.schemas = schemas;
    }

    public Page<Schema> getSchemas() {
        return schemas;
    }
}
