package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.conf.Configuration;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.storage.KindStorage;
import com.iodesystems.ferret.web.models.*;
import com.iodesystems.ferret.web.models.components.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    KindStorage kindStorage;

    @Autowired
    Configuration configuration;

    @Autowired
    ServletContext servletContext;

    @Autowired
    Navigation navigation;

    @RequestMapping("/")
    public String home(@ModelAttribute Page page) {
        page.setTitle("Home");
        page.setNavigation(navigation);

        Section section = new Section();
        page.getComponents().add(section);

        Sidebar sidebar = new Sidebar();
        page.setSidebar(sidebar);

        MenuGroup menuGroup = new MenuGroup("Entities");
        for (EntityDefinition entityDefinition : configuration.getEntityDefinitions()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setLabel(entityDefinition.getName());
            menuItem.setHref(servletContext.getContextPath() + "/entities/" + entityDefinition.getName());
            menuGroup.getMenuItems().add(menuItem);
        }
        sidebar.getMenuGroups().add(menuGroup);

        return "home";
    }
}
