package com.iodesystems.ferret.web.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class UrlFactory {

    @Autowired
    ServletContext servletContext;

    public String create(String url) {
        return servletContext.getContextPath() + url;
    }
}
