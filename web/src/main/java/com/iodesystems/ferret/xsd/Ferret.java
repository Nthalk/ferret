package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(namespace = "http://ferret.fulcrum.net/")
@XmlRootElement(name = "ferret")
@XmlAccessorOrder
public class Ferret {
    private List<Import> imports;
    private Types types;
    private Data data;
    private UserInterfaces ui;
    private Security security;
    private Routes routes;

    public Routes getRoutes() {
        return routes;
    }

    @XmlElement(name = "route")
    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public Security getSecurity() {
        return security;
    }

    @XmlElement(name = "security")
    public void setSecurity(Security security) {
        this.security = security;
    }


    public UserInterfaces getUi() {
        return ui;
    }

    @XmlElement(name = "ui")
    public void setUi(UserInterfaces ui) {
        this.ui = ui;
    }


    public Data getData() {
        return data;
    }

    @XmlElement(name = "data")
    public void setData(Data data) {
        this.data = data;
    }


    public List<Import> getImports() {
        return imports;
    }

    @XmlElement(name = "import")
    public void setImports(List<Import> imports) {
        this.imports = imports;
    }

    public Types getTypes() {
        return types;
    }

    @XmlElement(name = "types")
    public void setTypes(Types types) {
        this.types = types;
    }
}
