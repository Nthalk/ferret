package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class StaticAuthenticationUser {
    @XmlAttribute(required = true)
    private String name;
    @XmlAttribute(required = true)
    private String password;
    @XmlElement(name = "role")
    private List<StaticAuthenticationUserRole> roles;


    public List<StaticAuthenticationUserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<StaticAuthenticationUserRole> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
