package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class StaticAuthenticationProvider {
    @XmlElement(name = "user")
    private List<StaticAuthenticationUser> users;

    public List<StaticAuthenticationUser> getUsers() {
        return users;
    }

    public void setUsers(List<StaticAuthenticationUser> users) {
        this.users = users;
    }
}
