package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class StaticAuthenticationProvider extends AuthenticationProvider {

    private List<StaticAuthenticationUser> users;

    public List<StaticAuthenticationUser> getUsers() {
        return users;
    }

    @XmlElement(name = "user")
    public void setUsers(List<StaticAuthenticationUser> users) {
        this.users = users;
    }
}
