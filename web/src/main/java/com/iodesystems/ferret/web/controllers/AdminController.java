package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.services.AdminService;
import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.web.controllers.models.AdminIndex;
import com.iodesystems.ferret.web.controllers.models.AjaxRedirect;
import com.iodesystems.ferret.web.controllers.models.DataSourceCreate;
import com.iodesystems.ferret.web.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    DataSourcesService dataSourcesService;

    @Autowired
    AdminService adminService;

    @Autowired
    NotificationService notificationService;

    @GetMapping
    public String index(@ModelAttribute AdminIndex adminIndex) {
        adminIndex.setNavTree(adminService.getNavTree());
        return "admin/index";
    }

    @GetMapping("ajax/data-source-create")
    public String buildDataSource(@ModelAttribute DataSourceCreate dataSourceCreate) {
        return "admin/ajax/data_source_create";
    }

    @PostMapping("ajax/data-source-create")
    public String createDataSource(@Valid @ModelAttribute DataSourceCreate dataSourceCreate,
                                   BindingResult bindingResult,
                                   @ModelAttribute AjaxRedirect ajaxRedirect) {
        if (bindingResult.hasErrors()) {
            return "admin/ajax/data_source_create";
        }
        dataSourcesService.create(dataSourceCreate.getDataSource());
        ajaxRedirect.setUrl("/admin");
        notificationService.success("DataSource Created");
        return "ajax/redirect";
    }

}
