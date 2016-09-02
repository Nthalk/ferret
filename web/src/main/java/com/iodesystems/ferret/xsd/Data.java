package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Data {

    private DataConnection dataConnection;

    private List<Table> tables;

    private List<Options> options;

    public List<Options> getOptions() {
        return options;
    }

    @XmlElement(name = "options")
    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Table> getTables() {
        return tables;
    }

    @XmlElement(name = "table")
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }

    @XmlElements(
        value = {
            @XmlElement(name = "jdbc", type = JdbcDataConnection.class),
            @XmlElement(name = "jndi", type = JndiDataConnection.class)
        }
    )
    public void setDataConnection(DataConnection dataConnection) {
        this.dataConnection = dataConnection;
    }
}
