package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class Options extends HasId {
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    private String query;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    private String label;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    private String value;


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
