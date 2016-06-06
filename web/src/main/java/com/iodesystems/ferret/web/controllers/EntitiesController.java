package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.conf.Configuration;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.definition.FieldDefinition;
import com.iodesystems.ferret.data.search.EntitySearchService;
import com.iodesystems.ferret.web.controllers.models.*;
import com.iodesystems.ferret.web.models.*;
import com.iodesystems.ferret.web.models.components.*;
import com.iodesystems.ferret.web.models.components.form.Input;
import com.iodesystems.ferret.web.models.components.grid.GridRow;
import com.iodesystems.ferret.web.models.components.table.Cell;
import com.iodesystems.ferret.web.models.components.table.ColumnHeader;
import com.iodesystems.ferret.web.models.components.table.Row;
import com.iodesystems.ferret.web.providers.UrlFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/entities")
public class EntitiesController {

    @Autowired
    Configuration configuration;

    @Autowired
    Navigation navigation;

    @Autowired
    UrlFactory urlFactory;

    @Autowired
    EntitySearchService entitySearchService;


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String build(@ModelAttribute EntitiesCreateModel entitiesCreateModel) {
        entitiesCreateModel.setNavigation(navigation);
        entitiesCreateModel.setTitle("Create Entity");

        GridRow container = entitiesCreateModel.add(new GridRow());
        Form form = container.column(6, 3).add(new Form());
        Input name = form.add(new Input());
        name.setName("name");
        name.setLabel("Name");
        name.setValue(entitiesCreateModel.getName());

        return "entities/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute EntitiesCreateModel entitiesCreateModel) {
        return build(entitiesCreateModel);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(@ModelAttribute EntitiesIndexModel entitiesIndexModel) {
        entitiesIndexModel.setNavigation(navigation);
        entitiesIndexModel.setEntityDefinitions(configuration.getEntityDefinitions());
        entitiesIndexModel.setTitle("Entities");
        entitiesIndexModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities"), "Entities"));

        MenuGroup manageEntitiesMenu = new MenuGroup("Manage");
        entitiesIndexModel.getSidebar().addMenuGroup(manageEntitiesMenu);
        manageEntitiesMenu.addMenuItem(new MenuItem(
            urlFactory.create("/entities/" + "create"),
            "Create Entity"
        ));

        MenuGroup existingEntitiesMenu = new MenuGroup("Entities");
        entitiesIndexModel.getSidebar().getMenuGroups().add(existingEntitiesMenu);
        for (EntityDefinition entityDefinition : configuration.getEntityDefinitions()) {
            existingEntitiesMenu.getMenuItems().add(new MenuItem(
                urlFactory.create("/entities/" + entityDefinition.getName()),
                entityDefinition.getTitle()));
        }

        return "entities/index";
    }

    @RequestMapping(value = "/{name}/create", method = RequestMethod.POST)
    public String create(@PathVariable String name,
                         @ModelAttribute EntityCreateModel entityCreateModel) {
        entityCreateModel.setNavigation(navigation);
        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entityCreateModel.getErrors().reject("No entity found");
            return "entities";
        }
        return "entities/create_entity";
    }

    @RequestMapping(value = "/{name}/create", method = RequestMethod.GET)
    public String build(@PathVariable String name,
                        @ModelAttribute EntityCreateModel entityCreateModel) {
        entityCreateModel.setNavigation(navigation);
        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entityCreateModel.getErrors().reject("No entity found");
            return "entities";
        }

        entityCreateModel.setTitle(entityDefinition.getTitle());
        entityCreateModel.setSidebar(getEntitySidebar(entityDefinition));
        entityCreateModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities"), "Entities"));
        entityCreateModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities/" + name), entityDefinition.getTitle()));
        entityCreateModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities/" + name + "/create"), "Create"));

        Form form = new Form();
        for (FieldDefinition fieldDefinition : entityDefinition.getFieldDefinitions()) {
            Input input = new Input();
            input.setLabel(fieldDefinition.getName());
            form.getComponents().add(input);
        }

        entityCreateModel.getComponents().add(form);

        return "entities/create_entity";
    }

    @RequestMapping("/{name}/search")
    public String build(@PathVariable String name,
                        @ModelAttribute EntitySearchModel entitySearchModel) {

        entitySearchModel.setNavigation(navigation);

        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entitySearchModel.getErrors().reject("No entity found");
            return "entities";
        }
        entitySearchModel.setTitle(entityDefinition.getTitle());
        entitySearchModel.setSidebar(getEntitySidebar(entityDefinition));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities"), "Entities"));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities/" + name), entityDefinition.getTitle()));
        entitySearchModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities/" + name + "/search"), "Search"));

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
        entityIndexModel.setNavigation(navigation);

        EntityDefinition entityDefinition = getEntityByName(name);
        if (entityDefinition == null) {
            entityIndexModel.getErrors().reject("entity.not_found",
                                                new Object[]{name},
                                                "Entity not found: {0}");
            return "entities";
        }

        entityIndexModel.setTitle(entityDefinition.getTitle());
        entityIndexModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities"), "Entities"));
        entityIndexModel.getBreadcrumbs().add(new Breadcrumb(urlFactory.create("/entities/" + name), entityDefinition.getTitle()));

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
        menuGroup.getMenuItems().add(new MenuItem(urlFactory.create("/entities/" + name + "/"), "About"));
        menuGroup.getMenuItems().add(new MenuItem(urlFactory.create("/entities/" + name + "/search"), "Search"));
        menuGroup.getMenuItems().add(new MenuItem(urlFactory.create("/entities/" + name + "/create"), "Create"));

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
