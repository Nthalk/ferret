package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.List;

public class Routes extends HasOptionalId {
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "IDREF")
    private String ui;
    @XmlElement(name = "controller")
    private List<RouteController> routeControllers;
    @XmlElement
    private NotFound notFound;


    public NotFound getNotFound() {
        return notFound;
    }

    public void setNotFound(NotFound notFound) {
        this.notFound = notFound;
    }

    public String getUi() {
        return ui;
    }


    public void setUi(String ui) {
        this.ui = ui;
    }


    public List<RouteController> getRouteControllers() {
        return routeControllers;
    }

    public void setRouteControllers(List<RouteController> routeControllers) {
        this.routeControllers = routeControllers;
    }
}
