package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import java.net.URI;

public class Import {
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anyURI")
    private URI resource;

    public URI getResource() {
        return resource;
    }

    public void setResource(URI resource) {
        this.resource = resource;
    }
}
