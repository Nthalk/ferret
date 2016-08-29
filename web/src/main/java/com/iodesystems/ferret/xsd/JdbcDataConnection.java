package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class JdbcDataConnection extends DataConnection {
    @XmlAttribute(required = true)
    private String username;
    @XmlAttribute(required = true)
    private String password;
    @XmlAttribute(required = true)
    private String driver;
    @XmlAttribute(required = true)
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
