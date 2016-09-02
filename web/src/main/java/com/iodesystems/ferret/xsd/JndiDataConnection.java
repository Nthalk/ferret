package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class JndiDataConnection extends DataConnection {

    private String name;

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }
}
