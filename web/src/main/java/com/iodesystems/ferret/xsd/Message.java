package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class Message extends HasId {
    @XmlAttribute(required = true)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
