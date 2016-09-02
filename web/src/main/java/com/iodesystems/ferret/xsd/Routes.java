package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.List;

public class Routes extends HasOptionalId {
    private String ui;

    private List<RouteController> routeControllers;
    private NotFound notFound;


    public NotFound getNotFound() {
        return notFound;
    }

    @XmlElement
    public void setNotFound(NotFound notFound) {
        this.notFound = notFound;
    }

    public String getUi() {
        return ui;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    public void setUi(String ui) {
        this.ui = ui;
    }

    public List<RouteController> getRouteControllers() {
        return routeControllers;
    }

    @XmlElement(name = "controller")
    public void setRouteControllers(List<RouteController> routeControllers) {
        this.routeControllers = routeControllers;
    }
}
