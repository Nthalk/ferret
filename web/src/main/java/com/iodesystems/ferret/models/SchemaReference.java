package com.iodesystems.ferret.models;

public class SchemaReference {
    private final Integer id;
    private final String name;

    public SchemaReference(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {

        return id;
    }
}
