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

    @XmlElement(name = "import")
    private List<Import> imports;
    @XmlElement
    private Types types;
    @XmlElement(name = "data")
    private Data data;
    @XmlElement(name = "ui")
    private UserInterfaces ui;
    @XmlElement(name = "security")
    private Security security;
    @XmlElement(name = "route")
    private Routes routes;


    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }


    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }


    public UserInterfaces getUi() {
        return ui;
    }

    public void setUi(UserInterfaces ui) {
        this.ui = ui;
    }


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }


    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }
}
