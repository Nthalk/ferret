package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class TableField {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    public void setType(String type) {
        this.type = type;
    }
}
