package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Table extends HasId {

    List<TableField> fields;

    public List<TableField> getFields() {
        return fields;
    }

    @XmlElement(name = "field")
    public void setFields(List<TableField> fields) {
        this.fields = fields;
    }
}
