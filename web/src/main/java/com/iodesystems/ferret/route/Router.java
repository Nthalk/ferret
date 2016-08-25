package com.iodesystems.ferret.route;

import com.iodesystems.ferret.ui.UiResolver;
import com.iodesystems.ferret.xsd.Route;
import com.iodesystems.fn.Fn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Router {
    Map<String, RouteTree> routeTreesByMethod = new HashMap<>();

    public Router(UiResolver uiResolver, List<Route> routes) {
        if (routes == null) return;
        for (List<Routeable> routeablePath : Fn
            .of(routes)
            .convert(route -> new Routeable(uiResolver, route))
            .breadthPaths(Routeable::getChildren)) {
            for (Routeable lastPath : Fn.last(routeablePath)) {
                for (String method : lastPath.getMethod()) {
                    RouteTree routeTree = Fn.getOrAdd(routeTreesByMethod, method, RouteTree::new);
                    routeTree.extend(routeablePath);
                }
            }
        }
    }

    public void route(HttpServletRequest req, HttpServletResponse rsp) throws ServletException, IOException {
        List<RouteTree> routesToApply = new ArrayList<>();
        for (RouteTree current : Fn.get(routeTreesByMethod, req.getMethod())) {
            for (String segment : req.getServletPath().split("/")) {
                if (current.children.containsKey(segment)) {
                    current = current.children.get(segment);
                    routesToApply.add(current);
                } else if (current.hasCapture()) {
                    current = current.getCapture();
                    routesToApply.add(current);
                } else {
                    // NOT FOUND!
                }
            }
        }

        req.getRequestDispatcher("ferret.jsp").forward(req, rsp);
    }
}
