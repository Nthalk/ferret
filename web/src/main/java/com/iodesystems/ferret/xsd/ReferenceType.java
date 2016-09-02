package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class ReferenceType extends HasId {
    private String query;
    private String by;
    private String show;

    public String getQuery() {
        return query;
    }

    @XmlAttribute(required = true)
    public void setQuery(String query) {
        this.query = query;
    }

    public String getBy() {
        return by;
    }

    @XmlAttribute(required = true)
    public void setBy(String by) {
        this.by = by;
    }

    public String getShow() {
        return show;
    }

    @XmlAttribute(required = true)
    public void setShow(String show) {
        this.show = show;
    }
}
