package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.services.SchemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component

@RequestMapping(value = "/data-sources")
public class DataSourcesController {
    @Autowired
    DataSourcesService dataSourcesService;

    @Autowired
    SchemasService schemasService;

}
