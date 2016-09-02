package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class SecurityRoleAccess {

    private String name;

    private List<SecurityRoleAccessResource> roleAccessResources;


    public List<SecurityRoleAccessResource> getRoleAccessResources() {
        return roleAccessResources;
    }

    @XmlElement(name = "resource")
    public void setRoleAccessResources(List<SecurityRoleAccessResource> roleAccessResources) {
        this.roleAccessResources = roleAccessResources;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }
}
