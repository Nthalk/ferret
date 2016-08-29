package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class TableField {
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    private String name;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
