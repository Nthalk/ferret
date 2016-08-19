package com.iodesystems.ferret.models;

public class TableReference {
    private final Integer id;
    private final String name;

    public TableReference(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
