package com.iodesystems.ferret.route;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.iodesystems.ferret.xsd.*;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.ArrayList;
import java.util.List;

public class Routeable {
    public static Splitter PATH_SPLITTER = Splitter.on("/");
    private static Joiner PATH_JOINER = Joiner.on("/");
    private final List<Routeable> children = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private final Option<String> method;
    private final Option<String> id;
    private final Option<String> ui;


    public Routeable(Ferret.Route route) {
        method = Option.empty();
        id = Option.empty();
        ui = optionalString(route.getUi());
        for (Controller controller : route.getController()) {
            children.add(new Routeable(controller));
        }
    }

    public Routeable(Controller route) {
        method = Option.empty();
        id = Option.empty();
        ui = optionalString(route.getUi());

        addPath(route.getPath());
        for (com.iodesystems.ferret.xsd.List routeList : Option.of(route.getList())) {
            children.add(new Routeable(routeList));
        }
        for (Create routeCreate : Option.of(route.getCreate())) {
            children.add(new Routeable(routeCreate));
        }
        for (Show routeShow : Option.of(route.getShow())) {
            children.add(new Routeable(routeShow));
        }
    }

    public Routeable(com.iodesystems.ferret.xsd.List route) {
        method = Option.of("GET");
        id = optionalString(route.getId());
        ui = optionalString(route.getUi());
    }

    public Routeable(Create route) {
        method = Option.of("POST");
        id = optionalString(route.getId());
        ui = optionalString(route.getUi());
    }

    public Routeable(Show route) {
        method = Option.of("GET");
        id = optionalString(route.getId());
        ui = optionalString(route.getUi());
        addPath(":" + route.getBy());

        for (Controller controller : route.getController()) {
            children.add(new Routeable(controller));
        }
        for (Update routeUpdate : Option.of(route.getUpdate())) {
            children.add(new Routeable(routeUpdate));
        }
        for (Delete routeDelete : Option.of(route.getDelete())) {
            children.add(new Routeable(routeDelete));
        }
    }

    public Routeable(Update route) {
        method = Option.of("PUT");
        id = optionalString(route.getId());
        ui = optionalString(route.getUi());
    }

    public Routeable(Delete route) {
        method = Option.of("DELETE");
        id = optionalString(route.getId());
        ui = optionalString(route.getUi());
    }

    private Option<String> optionalString(String str) {
        return Option.of(Strings.emptyToNull(str));
    }

    private void addPath(String path) {
        path = Strings.nullToEmpty(path);
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        for (String segment : PATH_SPLITTER.split(path)) {
            this.path.add(segment);
        }
    }

    public List<Routeable> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();

        for (List<Routeable> routeables : Fn.of(this).breadthPaths(Routeable::getChildren)) {
            for (Routeable last : Fn.last(routeables)) {
                for (String method : last.getMethod()) {
                    toString.append(method);
                    toString.append(" /");
                    toString.append(PATH_JOINER.join(Fn.of(routeables)
                                                         .multiply(Routeable::getPath)
                                                         .except(String::isEmpty)));
                    toString.append(" -> ");

                    toString.append(PATH_JOINER.join(Fn.of(routeables)
                                                         .convert(Routeable::getUi)
                                                         .multiply(o -> o)));
                    toString.append("\n");
                }
            }
        }

        return toString.toString();
    }

    public Option<String> getId() {
        return id;
    }

    public Option<String> getUi() {
        return ui;
    }

    public List<String> getPath() {
        return path;
    }

    public Option<String> getMethod() {
        return method;
    }
}

