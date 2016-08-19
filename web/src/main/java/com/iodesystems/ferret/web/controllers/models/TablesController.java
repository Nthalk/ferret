package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.Table;
import com.iodesystems.ferret.services.DataSourcesService;
import com.iodesystems.ferret.services.SchemasService;
import com.iodesystems.ferret.services.TablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@Controller
@RequestMapping("/data-sources/{dataSourceId}/schemas/{schemaId}/tables")
public class TablesController {

    @Autowired
    SchemasService schemasService;

    @Autowired
    DataSourcesService dataSourcesService;

    @Autowired
    TablesService tablesService;

    @GetMapping("/create")
    public String build(
        @ModelAttribute TableCreate tableCreate,
        @PathVariable Integer dataSourceId,
        @PathVariable Integer schemaId) {
        tableCreate.setSchema(schemasService.findById(schemaId));
        tableCreate.setTable(new Table());
        tableCreate.setDataSource(dataSourcesService.findById(tableCreate.getSchema().getDataSourceId()));
        return "tables/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute TableCreate tableCreate,
                         @PathVariable Integer dataSourceId,
                         @PathVariable Integer schemaId) {
        tableCreate.getTable().setSchemaId(schemaId);
        Table table = tablesService.create(tableCreate.getTable());
        return "redirect:/data-sources/" + dataSourceId + "/schemas/" + schemaId + "/tables/" + table.getId();
    }

    @GetMapping("{tableId}")
    public String show(
        @ModelAttribute TableShow tableShow,
        @PathVariable Integer tableId) {
        tableShow.setTable(tablesService.findById(tableId));
        return "tables/show";
    }
}
