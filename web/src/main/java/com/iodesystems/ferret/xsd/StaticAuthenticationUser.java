package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class StaticAuthenticationUser {

    private String name;

    private String password;

    private List<StaticAuthenticationUserRole> roles;


    public List<StaticAuthenticationUserRole> getRoles() {
        return roles;
    }

    @XmlElement(name = "role")
    public void setRoles(List<StaticAuthenticationUserRole> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @XmlAttribute(required = true)
    public void setPassword(String password) {
        this.password = password;
    }
}
