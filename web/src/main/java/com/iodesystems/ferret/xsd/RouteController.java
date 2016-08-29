package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class RouteController extends HasOptionalId {
    @XmlAttribute
    private String label;
    @XmlAttribute(required = true)
    private String path;
    @XmlAttribute
    private String query;
    @XmlElement(name = "list")
    private ListRoute listRoute;
    @XmlElement(name = "show")
    private ShowRoute showRoute;
    @XmlElement(name = "create")
    private CreateRoute createRoute;


    public ListRoute getListRoute() {
        return listRoute;
    }

    public void setListRoute(ListRoute listRoute) {
        this.listRoute = listRoute;
    }


    public ShowRoute getShowRoute() {
        return showRoute;
    }

    public void setShowRoute(ShowRoute showRoute) {
        this.showRoute = showRoute;
    }


    public CreateRoute getCreateRoute() {
        return createRoute;
    }

    public void setCreateRoute(CreateRoute createRoute) {
        this.createRoute = createRoute;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
