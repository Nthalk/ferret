package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.web.models.Component;

import java.util.ArrayList;
import java.util.List;

public class Section extends Component {

    private String title;
    private String subTitle;
    private List<Component> components = new ArrayList<Component>();

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getType() {
        return "section";
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
