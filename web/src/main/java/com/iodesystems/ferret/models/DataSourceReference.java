package com.iodesystems.ferret.models;

public class DataSourceReference implements Reference{
    private final Integer id;
    private final String name;

    public DataSourceReference(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
