package com.iodesystems.ferret.route;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.iodesystems.ferret.ui.UiResolver;
import com.iodesystems.ferret.xsd.*;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.ArrayList;
import java.util.List;

public class Routeable {
    private static Splitter PATH_SPLITTER = Splitter.on("/");
    private static Joiner PATH_JOINER = Joiner.on("/");

    private final Iterable<Routeable> children;
    private final List<String> path;
    private final Option<String> id;
    private final Option<String> method;
    private Option<UserInterface> ui;

    public Routeable(UiResolver uiResolver,
                     RouteAction routeAction) {
        this(uiResolver, null, routeAction);
    }

    private Routeable(UiResolver uiResolver,
                      Routeable parent,
                      RouteAction routeAction) {
        path = new ArrayList<>();
        id = Option.of(routeAction.getId());

        if (routeAction instanceof RouteController) {
            RouteController controller = (RouteController) routeAction;
            String controllerPath = controller.getPath();
            if (controllerPath.startsWith("/")) {
                controllerPath = controllerPath.substring(1);
            }
            for (String pathPart : PATH_SPLITTER.split(controllerPath)) {
                if (pathPart.length() > 0) {
                    path.add(pathPart);
                }
            }

            children = Fn.of(controller.getController()).convert(action -> new Routeable(uiResolver, this, action))
                .join(Fn.of(Option.of(controller.getList())).convert(action -> new Routeable(uiResolver, this, action)))
                .join(Fn.of(Option.of(controller.getShow())).convert(action -> new Routeable(uiResolver, this, action)))
                .join(Fn.of(Option.of(controller.getCreate())).convert(action -> new Routeable(uiResolver, this, action)));

            method = Option.empty();

            if (!Strings.isNullOrEmpty(controller.getUi())) {
                ui = uiResolver.ui(controller.getUi());
            } else {
                ui = Fn.ofUnwrap(
                    Fn.of(controller.getId(),
                          controller.getQuery())
                        .convert(uiResolver::ui)
                ).first();
            }
        } else if (routeAction instanceof Route) {
            Route route = (Route) routeAction;
            String routePath = route.getPath();
            if (routePath.startsWith("/")) {
                routePath = routePath.substring(1);
            }
            for (String pathPart : PATH_SPLITTER.split(routePath)) {
                if (pathPart.length() > 0) {
                    this.path.add(pathPart);
                }
            }
            if (!Strings.isNullOrEmpty(route.getUi())) {
                ui = uiResolver.ui(route.getUi());
            } else {
                ui = Option.empty();
            }

            children = Fn.of(route.getController()).convert(action -> new Routeable(uiResolver, this, action));
            method = Option.empty();
        } else {
            if (routeAction instanceof RouteShow) {
                method = Option.of("GET");
                RouteShow show = (RouteShow) routeAction;
                path.add(":" + show.getBy());
                children = Fn
                    .of(show.getController())
                    .convert(action -> new Routeable(uiResolver, this, action))
                    .join(Fn.of(show.getDelete(), show.getUpdate())
                              .only(Fn.notNull())
                              .convert(
                                  action -> new Routeable(uiResolver, this, action)
                              ));
                if (!Strings.isNullOrEmpty(routeAction.getUi())) {
                    ui = uiResolver.ui(routeAction.getUi());
                } else {
                    ui = Fn.ofUnwrap(
                        Fn.of(routeAction.getId())
                            .only(Fn.notNull())
                            .convert(uiResolver::ui)
                    ).first();
                }
            } else if (routeAction instanceof RouteUpdate) {
                method = Option.of("PUT");
                children = Fn.empty();
                ui = Option.empty();
            } else if (routeAction instanceof RouteDelete) {
                method = Option.of("DELETE");
                children = Fn.empty();
                ui = Option.empty();
            } else if (routeAction instanceof RouteList) {
                method = Option.of("GET");
                children = Fn.empty();
                if (!Strings.isNullOrEmpty(routeAction.getUi())) {
                    ui = uiResolver.ui(routeAction.getUi());
                } else {
                    if (parent != null) {
                        ui = Fn.ofUnwrap(Fn.of(routeAction.getId())
                                             .join(Fn.convert(parent.getUi(), ui -> ui.getId() + "List"))
                                             .join(Fn.convert(parent.getId(), id -> id + "List"))
                                             .only(Fn.notNull())
                                             .convert(uiResolver::ui)).first();
                    } else {
                        ui = Fn.ofUnwrap(Fn.of(routeAction.getId())
                                             .convert(uiResolver::ui)).first();
                    }

                }
            } else if (routeAction instanceof RouteCreate) {
                method = Option.of("POST");
                children = Fn.empty();
                if (!Strings.isNullOrEmpty(routeAction.getUi())) {
                    ui = uiResolver.ui(routeAction.getUi());
                } else {
                    ui = Fn.ofUnwrap(
                        Fn.of(routeAction.getId())
                            .convert(uiResolver::ui)
                    ).first();
                }
            } else {
                throw new IllegalArgumentException("Unknown route action:" + routeAction.getClass().getName());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (List<Routeable> routeables : Fn.of(this).breadthPaths(Routeable::getChildren)) {
            for (Routeable lastRouteable : Fn.last(routeables)) {
                for (String method : lastRouteable.getMethod()) {
                    toString.append(method);
                    toString.append(" /");
                    toString.append(PATH_JOINER.join(
                        Fn.of(routeables)
                            .convert(Routeable::getPath)
                            .multiply(list -> list)
                            .except(String::isEmpty)));

                    toString.append(" -> ");

                    toString.append(PATH_JOINER.join(
                        Fn.of(routeables)
                            .convert(Routeable::getUi)
                            .only(Option::isPresent)
                            .convert(Option::get)
                            .convert(UserInterface::getId)));

                    toString.append("\n");
                }
            }
        }
        return toString.toString();
    }

    public List<String> getPath() {
        return path;
    }

    public Option<String> getId() {
        return id;
    }

    public Option<UserInterface> getUi() {
        return ui;
    }

    public Option<String> getMethod() {
        return method;
    }

    public Iterable<Routeable> getChildren() {
        return children;
    }
}
