package com.iodesystems.ferret.web.providers;

import com.iodesystems.ferret.web.models.Icon;
import com.iodesystems.ferret.web.models.Navigation;
import com.iodesystems.ferret.web.models.components.Link;
import com.iodesystems.ferret.web.models.navigation.DropDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class NavigationProvider {

    @Autowired
    ServletContext servletContext;

    @Bean
    @Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Navigation navigation() {
        Navigation navigation = new Navigation();
        navigation.setTitle("Ferret");
        DropDown dropDown = new DropDown();

        dropDown.setTitle("Admin");
        dropDown.setIcon(Icon.settings);
        Link link = new Link();
        link.setText("Entities");
        link.setHref(servletContext.getContextPath() + "/admin/entities");
        link.setIcon(Icon.settings);
        dropDown.addLink(link);
        navigation.addDropDown(dropDown);

        return navigation;
    }
}
