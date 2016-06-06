package com.iodesystems.ferret.web.models;

import java.util.ArrayList;
import java.util.List;

public abstract class NestedComponent implements Component {
    private List<Component> components = new ArrayList<Component>();

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public <T extends Component> T add(T component) {
        components.add(component);
        return component;
    }

}
