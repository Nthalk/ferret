package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class SecurityRoleAccessResource {

    private String match;
    private SecurityAccessResourceType resource;

    private SecurityAccessPolicy policy;


    public String getMatch() {
        return match;
    }

    @XmlAttribute(required = true)
    public void setMatch(String match) {
        this.match = match;
    }

    public SecurityAccessResourceType getResource() {
        return resource;
    }

    @XmlAttribute(required = true)
    public void setResource(SecurityAccessResourceType resource) {
        this.resource = resource;
    }

    public SecurityAccessPolicy getPolicy() {
        return policy;
    }

    @XmlAttribute(required = true)
    public void setPolicy(SecurityAccessPolicy policy) {
        this.policy = policy;
    }
}
