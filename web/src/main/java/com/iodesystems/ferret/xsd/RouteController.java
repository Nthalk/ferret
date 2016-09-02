package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class RouteController extends HasOptionalId {
    private String label;
    private String path;
    private String query;
    private ListRoute listRoute;
    private ShowRoute showRoute;
    private CreateRoute createRoute;

    public ListRoute getListRoute() {
        return listRoute;
    }

    @XmlElement(name = "list")
    public void setListRoute(ListRoute listRoute) {
        this.listRoute = listRoute;
    }

    public ShowRoute getShowRoute() {
        return showRoute;
    }

    @XmlElement(name = "show")
    public void setShowRoute(ShowRoute showRoute) {
        this.showRoute = showRoute;
    }

    public CreateRoute getCreateRoute() {
        return createRoute;
    }

    @XmlElement(name = "create")
    public void setCreateRoute(CreateRoute createRoute) {
        this.createRoute = createRoute;
    }


    public String getLabel() {
        return label;
    }

    @XmlAttribute
    public void setLabel(String label) {
        this.label = label;
    }

    public String getPath() {
        return path;
    }

    @XmlAttribute(required = true)
    public void setPath(String path) {
        this.path = path;
    }

    public String getQuery() {
        return query;
    }

    @XmlAttribute
    public void setQuery(String query) {
        this.query = query;
    }
}
