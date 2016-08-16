package com.iodesystems.ferret.web.controllers.models;

import com.iodesystems.ferret.models.Table;
import com.iodesystems.ferret.services.SchemasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
@RequestMapping("/data-sources/{dataSourceId}/schemas/{schemaId}/tables")
public class TablesController {

    @Autowired
    SchemasService schemasService;

    @RequestMapping(
        name = "tableCreate",
        value = "/create",
        method = RequestMethod.GET)
    public String create(
        @ModelAttribute TableCreate tableCreate,
        @PathVariable Integer dataSourceId,
        @PathVariable Integer schemaId) {
        tableCreate.setSchema(schemasService.findById(schemaId));
        tableCreate.setTable(new Table());
        return "tables/create";
    }
}
