package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class SecurityRoleAccessResource {
    @XmlAttribute(required = true)
    private String match;
    @XmlAttribute(required = true)
    private SecurityAccessResourceType resource;
    @XmlAttribute(required = true)
    private SecurityAccessPolicy policy;


    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public SecurityAccessResourceType getResource() {
        return resource;
    }

    public void setResource(SecurityAccessResourceType resource) {
        this.resource = resource;
    }

    public SecurityAccessPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(SecurityAccessPolicy policy) {
        this.policy = policy;
    }
}
