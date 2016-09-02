package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class Message extends HasId {

    private String value;

    public String getValue() {
        return value;
    }

    @XmlAttribute(required = true)
    public void setValue(String value) {
        this.value = value;
    }
}
