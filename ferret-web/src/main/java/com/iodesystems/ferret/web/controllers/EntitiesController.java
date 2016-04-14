package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.conf.Configuration;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.definition.FieldDefinition;
import com.iodesystems.ferret.web.controllers.models.EntityCreateModel;
import com.iodesystems.ferret.web.controllers.models.EntityIndexModel;
import com.iodesystems.ferret.web.models.Breadcrumb;
import com.iodesystems.ferret.web.models.Paragraph;
import com.iodesystems.ferret.web.models.components.Section;
import com.iodesystems.ferret.web.models.components.Table;
import com.iodesystems.ferret.web.models.components.Text;
import com.iodesystems.ferret.web.models.components.table.Cell;
import com.iodesystems.ferret.web.models.components.table.ColumnHeader;
import com.iodesystems.ferret.web.models.components.table.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/entities")
public class EntitiesController {

    @Autowired
    Configuration configuration;

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/{name}/create")
    public String create(@PathVariable String name,
                         @ModelAttribute EntityCreateModel entityCreateModel) {
        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entityCreateModel.getErrrors().reject("No entity found");
            return "create";
        }
        return "create";
    }

    @RequestMapping("/{name}")
    public String index(@PathVariable String name,
                        @ModelAttribute EntityIndexModel entityIndexModel) {
        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entityIndexModel.getErrrors().reject("No entity found");
            return "entities";
        }

        entityIndexModel.setTitle(entityDefinition.getTitle());
        entityIndexModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/", "Entities"));
        entityIndexModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/entities/" + name, name));

        String description = entityDefinition.getDescription();
        if (description != null) {
            entityIndexModel.getComponents().add(new Paragraph(description));
        }

        Section fields = new Section();
        fields.setTitle("Fields");
        fields.setSubTitle("properties on " + entityDefinition.getTitle());
        Table fieldsTable = new Table();
        fields.getComponents().add(fieldsTable);
        fieldsTable.getColumnHeaders().add(new ColumnHeader(new Text("Name")));
        fieldsTable.getColumnHeaders().add(new ColumnHeader(new Text("Description")));
        fieldsTable.getColumnHeaders().add(new ColumnHeader(new Text("Type")));
        for (FieldDefinition fieldDefinition : entityDefinition.getFieldDefinitions()) {
            Row row = new Row();
            row.getCells().add(new Cell(new Text(fieldDefinition.getName())));
            row.getCells().add(new Cell(new Text(fieldDefinition.getDescription())));
            row.getCells().add(new Cell(new Text(fieldDefinition.getTypeDefinition().getName())));
            fieldsTable.getRows().add(row);
        }

        entityIndexModel.getComponents().add(fields);
        return "entities";
    }

    public EntityDefinition getEntityByName(String name) {
        for (EntityDefinition entityDefinition : configuration.getEntityDefinitions()) {
            if (entityDefinition.getName().equals(name)) {
                return entityDefinition;
            }

        }
        return null;
    }


}
