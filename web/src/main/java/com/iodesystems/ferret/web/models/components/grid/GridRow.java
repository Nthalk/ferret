package com.iodesystems.ferret.web.models.components.grid;

import com.iodesystems.ferret.web.models.Component;

import java.util.ArrayList;
import java.util.List;

public class GridRow implements Component {

    private List<GridColumn> columns = new ArrayList<GridColumn>();

    public List<GridColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GridColumn> columns) {
        this.columns = columns;
    }

    public GridColumn column(int width) {
        GridColumn gridColumn = column();
        gridColumn.setWidth(width);
        return gridColumn;
    }

    public GridColumn column(int width, int offset) {
        GridColumn gridColumn = column();
        gridColumn.setWidth(width);
        gridColumn.setOffset(offset);
        return gridColumn;
    }

    public GridColumn column() {
        GridColumn column = new GridColumn();
        columns.add(column);
        return column;
    }

    @Override
    public String getType() {
        return "grid/row";
    }
}
