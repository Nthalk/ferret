package com.iodesystems.ferret.web.models.components.table;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private String id;
    private List<Cell> cells = new ArrayList<Cell>();

    public Row(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
