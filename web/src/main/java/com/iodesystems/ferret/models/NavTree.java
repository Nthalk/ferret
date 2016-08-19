package com.iodesystems.ferret.models;

import com.iodesystems.ferret.services.NavNode;

import java.util.List;

public class NavTree extends NavNode {
    public NavTree(List<NavNode> nodes) {
        super("root", null, null);
        children = nodes;
    }
}
