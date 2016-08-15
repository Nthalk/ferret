package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.services.SchemasService;
import com.iodesystems.ferret.web.controllers.models.DataSourceAddSchema;
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

    @RequestMapping(name = "dataSources", method = RequestMethod.GET)
    public String index(@ModelAttribute DataSourcesIndex dataSourcesIndex,
                        @RequestParam(defaultValue = "1") Integer page) {
        dataSourcesIndex.setDataSources(dataSourcesService.find(new PageRequest(page)));
        return "data_sources";
    }

    @RequestMapping(
        value = "{id}",
        name = "dataSourceShow",
        method = RequestMethod.GET)
    public String show(@PathVariable Integer id,
                       @RequestParam(defaultValue = "1") Integer schemasPage,
                       @ModelAttribute DataSourceShow dataSourceShow) {
        dataSourceShow.setDataSource(dataSourcesService.findById(id));
        dataSourceShow.setSchemas(schemasService.find(new PageRequest(schemasPage)));
        return "data_source";
    }

    @RequestMapping(
        value = "{id}/schema/add",
        name = "dataSourceAddSchema",
        method = RequestMethod.GET
    )
    public String addSchema(
        @PathVariable Integer id,
        @ModelAttribute DataSourceAddSchema dataSourceAddSchema
    ) {
        dataSourceAddSchema.setDataSource(dataSourcesService.findById(id));
        Schema schema = new Schema();
        schema.setDataSourceId(id);
        dataSourceAddSchema.setSchema(schema);
        return "data_source/add_schema";
    }

    @RequestMapping(
        value = "{id}/schema/add",
        method = RequestMethod.POST
    )
    public String addSchemaDo(
        @PathVariable Integer id,
        @ModelAttribute DataSourceAddSchema dataSourceAddSchema
    ) {
        schemasService.create(dataSourceAddSchema.getSchema());
        return "redirect:/data-sources/" + id;
    }
}
