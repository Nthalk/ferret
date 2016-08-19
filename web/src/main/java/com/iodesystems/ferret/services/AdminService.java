package com.iodesystems.ferret.services;

import com.iodesystems.ferret.models.NavTree;
import com.iodesystems.fn.Fn;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.iodesystems.ferret.db.Tables.*;

@Component
public class AdminService {
    @Autowired
    DSLContext db;


    public NavTree getNavTree() {
        List<NavNode> dataSources = db
            .select(DATA_SOURCE.ID, DATA_SOURCE.NAME)
            .from(DATA_SOURCE)
            .fetch(r -> new NavNode("dataSource", r.value2(), r.value1()));

        Map<Integer, NavNode> dataSourcesById = Fn.of(dataSources).index(NavNode::getId);

        Map<Integer, NavNode> schemasById = Fn.of(db.select(SCHEMA.ID, SCHEMA.NAME, SCHEMA.DATA_SOURCE_ID).from(SCHEMA).fetch(r -> {
            NavNode schemaNode = new NavNode("schema", r.value2(), r.value1());
            dataSourcesById.get(r.value3()).addChild(schemaNode);
            return schemaNode;
        })).index(NavNode::getId);

        Map<Integer, NavNode> tablesById = Fn.of(db.select(TABLE.ID, TABLE.NAME, TABLE.SCHEMA_ID).from(TABLE).fetch(r -> {
            NavNode tableNode = new NavNode("table", r.value2(), r.value1());
            schemasById.get(r.value3()).addChild(tableNode);
            return tableNode;
        })).index(NavNode::getId);

        return new NavTree(dataSources);
    }
}
