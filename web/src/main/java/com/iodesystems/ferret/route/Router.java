package com.iodesystems.ferret.route;

import com.iodesystems.ferret.xsd.Ferret;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {
    Map<String, RouteTree> routeTreesByMethod = new HashMap<>();

    public Router(Ferret.Route route) {
        if (route == null) return;
        for (List<Routeable> routeablePath : Fn.of(route.getController())
            .convert(Routeable::new)
            .breadthPaths(Routeable::getChildren)) {
            for (Routeable lastPath : Fn.last(routeablePath)) {
                for (String method : lastPath.getMethod()) {
                    RouteTree routeTree = Fn.getOrAdd(routeTreesByMethod, method, RouteTree::new);
                    routeTree.extend(routeablePath);
                }
            }
        }
    }

    public RouteTree route(String method, String path) {
        for (RouteTree routeTree : Fn.get(routeTreesByMethod, method)) {
            for (String part : Routeable.PATH_SPLITTER.split(path)) {
                Option<RouteTree> next = routeTree.get(part);
                if (next.isPresent()) {
                    routeTree = next.get();
                } else {
                    routeTree = notFound();
                }
            }
            return routeTree;
        }
        return notFound();
    }

    private RouteTree notFound() {
        return null;
    }
}
