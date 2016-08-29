package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Security {

    @XmlElements(
        value = {
            @XmlElement(name = "staticAuthentication", type = StaticAuthenticationProvider.class)
        }
    )
    private AuthenticationProvider authenticationProvider;
    @XmlElement(name = "role")
    private List<SecurityRoleAccess> roleAccessList;

    public List<SecurityRoleAccess> getRoleAccessList() {
        return roleAccessList;
    }

    public void setRoleAccessList(List<SecurityRoleAccess> roleAccessList) {
        this.roleAccessList = roleAccessList;
    }


    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
}
