package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.query.PageRequest;
import com.iodesystems.ferret.services.SchemasService;
import com.iodesystems.ferret.services.TablesService;
import com.iodesystems.ferret.web.controllers.models.SchemaShow;
import com.iodesystems.ferret.web.controllers.models.SchemasIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@Controller
@RequestMapping("/schemas")
public class SchemasController {

    @Autowired
    SchemasService schemasService;

    @Autowired
    TablesService tablesService;

    @RequestMapping(method = RequestMethod.GET)
    public String schemas(@RequestParam(defaultValue = "1") Integer page,
                          @ModelAttribute SchemasIndex schemasIndex) {
        schemasIndex.setSchemas(schemasService.find(new PageRequest(page)));
        return "schemas";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String schema(@PathVariable Integer id,
                         @RequestParam(defaultValue = "1") Integer tablesPage,
                         @ModelAttribute SchemaShow schemaShow) {
        schemaShow.setSchema(schemasService.findById(id));
        schemaShow.setTables(tablesService.find(schemaShow.getSchema(), new PageRequest(tablesPage)));
        return "schema";
    }
}
