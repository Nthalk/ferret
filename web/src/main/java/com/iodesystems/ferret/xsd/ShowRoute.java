package com.iodesystems.ferret.xsd;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.List;

public class ShowRoute extends Route {

    private List<RouteController> controllers;

    private UpdateRoute updateRoute;

    private DeleteRoute deleteRoute;

    private String by;


    public String getBy() {
        return by;
    }

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    public void setBy(String by) {
        this.by = by;
    }

    public UpdateRoute getUpdateRoute() {
        return updateRoute;
    }

    @XmlElement(name = "update")
    public void setUpdateRoute(UpdateRoute updateRoute) {
        this.updateRoute = updateRoute;
    }

    public DeleteRoute getDeleteRoute() {
        return deleteRoute;
    }

    @XmlElement(name = "delete")
    public void setDeleteRoute(DeleteRoute deleteRoute) {
        this.deleteRoute = deleteRoute;
    }

    public List<RouteController> getControllers() {
        return controllers;
    }

    @XmlElement(name = "controller")
    public void setControllers(List<RouteController> controllers) {
        this.controllers = controllers;
    }
}
