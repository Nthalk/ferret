package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Data {
    @XmlElements(
        value = {
            @XmlElement(name = "jdbc", type = JdbcDataConnection.class),
            @XmlElement(name = "jndi", type = JndiDataConnection.class)
        }
    )
    private DataConnection dataConnection;
    @XmlElement(name = "table")
    private List<Table> tables;
    @XmlElement(name = "options")
    private List<Options> options;

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }

    public void setDataConnection(DataConnection dataConnection) {
        this.dataConnection = dataConnection;
    }
}
