package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;

public class Options extends HasId {

    private String query;

    private String label;

    private String value;


    public String getQuery() {
        return query;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    public void setQuery(String query) {
        this.query = query;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    public void setValue(String value) {
        this.value = value;
    }
}
