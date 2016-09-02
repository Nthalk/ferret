package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import java.net.URI;

public class Import {
    private URI resource;

    public URI getResource() {
        return resource;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    public void setResource(URI resource) {
        this.resource = resource;
    }
}
