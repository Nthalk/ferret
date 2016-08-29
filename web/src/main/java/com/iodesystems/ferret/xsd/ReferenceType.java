package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class ReferenceType extends HasId {
    @XmlAttribute(required = true)
    private String query;
    @XmlAttribute(required = true)
    private String by;
    @XmlAttribute(required = true)
    private String show;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
