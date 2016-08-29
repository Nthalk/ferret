package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.List;

public class ShowRoute {
    @XmlElement(name = "controller")
    private List<RouteController> controllers;
    @XmlElement(name = "update")
    private UpdateRoute updateRoute;
    @XmlElement(name = "delete")
    private DeleteRoute deleteRoute;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "NCName")
    private String by;


    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public UpdateRoute getUpdateRoute() {
        return updateRoute;
    }

    public void setUpdateRoute(UpdateRoute updateRoute) {
        this.updateRoute = updateRoute;
    }


    public DeleteRoute getDeleteRoute() {
        return deleteRoute;
    }

    public void setDeleteRoute(DeleteRoute deleteRoute) {
        this.deleteRoute = deleteRoute;
    }

    public List<RouteController> getControllers() {
        return controllers;
    }

    public void setControllers(List<RouteController> controllers) {
        this.controllers = controllers;
    }
}
