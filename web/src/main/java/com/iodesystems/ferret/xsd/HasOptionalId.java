package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class HasOptionalId {
    private String id;

    public String getId() {
        return id;
    }

    @XmlAttribute
    @XmlSchemaType(name = "ID")
    public void setId(String id) {
        this.id = id;
    }
}
