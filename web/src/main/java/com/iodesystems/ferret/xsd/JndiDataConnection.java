package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class JndiDataConnection extends DataConnection {
    @XmlAttribute(required = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
