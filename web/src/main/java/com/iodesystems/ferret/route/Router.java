package com.iodesystems.ferret.route;

import com.google.common.base.Splitter;
import com.iodesystems.fn.Fn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static final Splitter PATH_SPLITTER = Splitter.on("/");
    private final Map<String, RouteSegment> routeSegmentsByMethod = new HashMap<>();
    private RouteHandler notFoundHandler = null;

    public void route(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String path = request.getServletPath();
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        RouteSegment finalRouteSegment = null;
        String method = request.getMethod();
        for (RouteSegment routeSegment : Fn.get(routeSegmentsByMethod, method)) {
            for (String pathSegment : PATH_SPLITTER.split(path)) {
                if (routeSegment.isCapture()) {
                    request.setAttribute(routeSegment.getPathSegment(), pathSegment);
                    routeSegment = routeSegment.getChildCapture();
                } else {
                    routeSegment = routeSegment.getChild(pathSegment);
                    if (routeSegment == null) {
                        break;
                    }
                }
            }
            finalRouteSegment = routeSegment;
        }
        if (finalRouteSegment != null) {
            RouteHandler handler = finalRouteSegment.getHandler();
            handler.handle(request, response);
        } else if (notFoundHandler != null) {
            notFoundHandler.handle(request, response);
        } else {
            try {
                response.sendError(404, "Not found");
            } catch (IOException e) {
                throw new ServletException(e);
            }
        }

    }

    public void extend(String method, String path, RouteHandler routeHandler) {
        RouteSegment routeSegment = Fn.getOrAdd(routeSegmentsByMethod, method, () -> new RouteSegment(""));
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        for (String pathSegment : PATH_SPLITTER.split(path)) {
            RouteSegment nextSegment = new RouteSegment(pathSegment);
            routeSegment.extend(nextSegment);
            routeSegment = nextSegment;
        }
        routeSegment.setHandler(routeHandler);
    }
}
