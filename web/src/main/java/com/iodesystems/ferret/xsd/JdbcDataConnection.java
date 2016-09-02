package com.iodesystems.ferret.xsd;

import javax.xml.bind.annotation.XmlAttribute;

public class JdbcDataConnection extends DataConnection {

    private String username;

    private String password;

    private String driver;

    private String url;

    public String getUsername() {
        return username;
    }

    @XmlAttribute(required = true)
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlAttribute(required = true)
    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    @XmlAttribute(required = true)
    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    @XmlAttribute(required = true)
    public void setUrl(String url) {
        this.url = url;
    }
}
