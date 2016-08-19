package com.iodesystems.ferret.services;

import java.util.ArrayList;
import java.util.List;

public class NavNode {
    private final String type;
    private final String label;
    private final Integer id;
    protected List<NavNode> children = null;

    public NavNode(String type, String label, Integer id) {
        this.type = type;
        this.label = label;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public Integer getId() {
        return id;
    }

    public void addChild(NavNode node) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(node);
    }

    public List<NavNode> getChildren() {
        return children;
    }
}
