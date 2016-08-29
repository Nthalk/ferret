package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class HasId {
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
