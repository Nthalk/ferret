package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.conf.Configuration;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.definition.FieldDefinition;
import com.iodesystems.ferret.data.search.EntitySearchService;
import com.iodesystems.ferret.web.controllers.models.EntityCreateModel;
import com.iodesystems.ferret.web.controllers.models.EntityIndexModel;
import com.iodesystems.ferret.web.controllers.models.EntitySearchModel;
import com.iodesystems.ferret.web.models.*;
import com.iodesystems.ferret.web.models.components.EntitySearchTable;
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

    @Autowired
    EntitySearchService entitySearchService;

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

    @RequestMapping("/{name}/search")
    public String create(@PathVariable String name,
                         @ModelAttribute EntitySearchModel entitySearchModel) {
        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entitySearchModel.getErrrors().reject("No entity found");
            return "entities/search_entities";
        }
        entitySearchModel.setTitle(entityDefinition.getTitle());
        entitySearchModel.setSidebar(getEntitySidebar(entityDefinition));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/", "Entities"));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/entities/" + name, entityDefinition.getTitle()));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/entities/" + name + "/search", "Search"));

        EntitySearchTable entitySearchTable = new EntitySearchTable(entityDefinition);
        entitySearchTable.setQuery(entitySearchModel.getQuery());
        entitySearchModel.getComponents().add(entitySearchTable);

        entitySearchTable.setSearchResult(entitySearchService.search(entityDefinition,
                                                                     entitySearchModel.getQuery(),
                                                                     entitySearchModel.getLimit(), entitySearchModel.getOffset()));
        return "entities/search_entities";
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
        entityIndexModel.getBreadcrumbs().add(new Breadcrumb(servletContext.getContextPath() + "/entities/" + name, entityDefinition.getTitle()));

        entityIndexModel.setSidebar(getEntitySidebar(entityDefinition));

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

    private Sidebar getEntitySidebar(EntityDefinition entityDefinition) {
        String name = entityDefinition.getName();
        Sidebar sidebar = new Sidebar();
        MenuGroup menuGroup = new MenuGroup(entityDefinition.getTitle());
        menuGroup.getMenuItems().add(new MenuItem(servletContext.getContextPath() + "/entities/" + name + "/", "About"));
        menuGroup.getMenuItems().add(new MenuItem(servletContext.getContextPath() + "/entities/" + name + "/search", "Search"));
        menuGroup.getMenuItems().add(new MenuItem(servletContext.getContextPath() + "/entities/" + name + "/create", "Create"));

        sidebar.getMenuGroups().add(menuGroup);
        return sidebar;
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
