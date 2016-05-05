package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;
import com.iodesystems.ferret.web.models.components.table.ColumnHeader;
import com.iodesystems.ferret.web.models.components.table.Row;

import java.util.ArrayList;
import java.util.List;

public class Table extends Component {
    private List<ColumnHeader> columnHeaders = new ArrayList<ColumnHeader>();
    private List<Row> rows = new ArrayList<Row>();

    public List<ColumnHeader> getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(List<ColumnHeader> columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String getType() {
        return "table";
    }
}
