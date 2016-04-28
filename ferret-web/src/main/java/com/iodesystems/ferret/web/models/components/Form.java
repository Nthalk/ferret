package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;

import java.util.ArrayList;
import java.util.List;

public class Form extends Component {
    private List<Component> components = new ArrayList<Component>();

    @Override
    public String getType() {
        return "form";
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
