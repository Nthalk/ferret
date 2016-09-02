package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class StaticAuthenticationUserRole {

    private String name;

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }
}
