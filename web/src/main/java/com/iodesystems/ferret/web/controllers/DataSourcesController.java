package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.services.SchemasService;
import com.iodesystems.ferret.web.controllers.models.DataSourceShow;
import com.iodesystems.ferret.web.controllers.models.DataSourcesIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component

@RequestMapping(value = "/data-sources")
public class DataSourcesController {
    @Autowired
    DataSourcesService dataSourcesService;

    @Autowired
    SchemasService schemasService;

    @RequestMapping(
        name = "dataSources",
        method = RequestMethod.GET)
    public String index(@ModelAttribute DataSourcesIndex dataSourcesIndex,
                        @RequestParam(defaultValue = "1") Integer page) {
        dataSourcesIndex.setDataSources(dataSourcesService.find(new PageRequest(page)));
        return "data_sources/index";
    }

    @RequestMapping(
        value = "{id}",
        method = RequestMethod.GET)
    public String show(@PathVariable Integer id,
                       @RequestParam(defaultValue = "1") Integer schemasPage,
                       @ModelAttribute DataSourceShow dataSourceShow) {
        dataSourceShow.setDataSource(dataSourcesService.findById(id));
        dataSourceShow.setSchemas(
            schemasService.find(
                dataSourceShow.getDataSource(),
                new PageRequest(schemasPage)));
        return "data_sources/show";
    }
}
