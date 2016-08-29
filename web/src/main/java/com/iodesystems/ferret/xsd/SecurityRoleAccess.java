package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class SecurityRoleAccess {
    @XmlAttribute(required = true)
    private String name;
    @XmlElement(name = "resource")
    private List<SecurityRoleAccessResource> roleAccessResources;


    public List<SecurityRoleAccessResource> getRoleAccessResources() {
        return roleAccessResources;
    }

    public void setRoleAccessResources(List<SecurityRoleAccessResource> roleAccessResources) {
        this.roleAccessResources = roleAccessResources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
