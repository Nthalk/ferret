package com.iodesystems.ferret.models;

public class DataSource {
    private String name;
    private Integer schemaCount;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchemaCount(Integer schemaCount) {
        this.schemaCount = schemaCount;
    }

    public Integer getSchemaCount() {
        return schemaCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
