package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class VirtualTypeField {

    private String name;

    private String typeId;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    @XmlAttribute(name = "type")
    @XmlSchemaType(name = "IDREF")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
