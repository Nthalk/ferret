package com.iodesystems.ferret.models;

import org.hibernate.validator.constraints.NotEmpty;

public class DataSource {
    private String name;
    private Integer schemaCount;
    private Integer id;
    private AccessType accessType;
    private Boolean allowModifySchemas;

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSchemaCount() {
        return schemaCount;
    }

    public void setSchemaCount(Integer schemaCount) {
        this.schemaCount = schemaCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public Boolean getAllowModifySchemas() {
        return allowModifySchemas;
    }

    public void setAllowModifySchemas(Boolean allowModifySchemas) {
        this.allowModifySchemas = allowModifySchemas;
    }

    public enum AccessType {
        JNDI,
        JDBC
    }
}
