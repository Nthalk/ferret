package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Security {
    private AuthenticationProvider authenticationProvider;
    private List<SecurityRoleAccess> roleAccessList;

    public List<SecurityRoleAccess> getRoleAccessList() {
        return roleAccessList;
    }

    @XmlElement(name = "role")
    public void setRoleAccessList(List<SecurityRoleAccess> roleAccessList) {
        this.roleAccessList = roleAccessList;
    }


    public AuthenticationProvider getAuthenticationProvider() {
        return authenticationProvider;
    }

    @XmlElements(
        value = {
            @XmlElement(name = "staticAuthentication", type = StaticAuthenticationProvider.class)
        }
    )
    public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
}
