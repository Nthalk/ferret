package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class HasId {
    private String id;

    public String getId() {
        return id;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "ID")
    public void setId(String id) {
        this.id = id;
    }
}
