package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.models.Schema;
import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.services.SchemasService;
import com.iodesystems.ferret.services.TablesService;
import com.iodesystems.ferret.web.controllers.models.SchemaCreate;
import com.iodesystems.ferret.web.controllers.models.SchemaShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@Controller
@RequestMapping("/data-sources/{dataSourceId}/schemas")
public class SchemasController {

    @Autowired
    SchemasService schemasService;

    @Autowired
    TablesService tablesService;

    @Autowired
    DataSourcesService dataSourcesService;

    @RequestMapping(
        value = "{schemaId}",
        method = RequestMethod.GET)
    public String show(@RequestParam(defaultValue = "1") Integer tablesPage,
                       @ModelAttribute SchemaShow schemaShow,
                       @PathVariable Integer dataSourceId,
                       @PathVariable Integer schemaId) {
        schemaShow.setSchema(schemasService.findById(schemaId));
        schemaShow.setTables(tablesService.find(schemaShow.getSchema(), new PageRequest(tablesPage)));
        return "schemas/show";
    }

    @RequestMapping(
        value = "/create",
        method = RequestMethod.POST
    )
    public String create(
        @PathVariable Integer dataSourceId,
        @ModelAttribute SchemaCreate schemaCreate
    ) {
        schemasService.create(schemaCreate.getSchema());
        return "redirect:/data-sources/" + dataSourceId;
    }

    @RequestMapping(
        value = "/create",
        method = RequestMethod.GET
    )
    public String build(
        @ModelAttribute SchemaCreate schemaCreate,
        @PathVariable Integer dataSourceId) {
        schemaCreate.setDataSource(dataSourcesService.findById(dataSourceId));
        Schema schema = new Schema();
        schema.setDataSourceId(dataSourceId);
        schemaCreate.setSchema(schema);
        return "schemas/create";
    }
}
