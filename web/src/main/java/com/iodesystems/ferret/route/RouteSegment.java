package com.iodesystems.ferret.route;

import java.util.HashMap;
import java.util.Map;

class RouteSegment {

    private final boolean isCapture;
    private final Map<String, RouteSegment> children = new HashMap<>();
    private String pathSegment;
    private RouteSegment childCapture;
    private RouteHandler handler;

    public RouteSegment(String pathSegment) {
        this.pathSegment = pathSegment;
        isCapture = pathSegment.startsWith(":");
    }

    public boolean isCapture() {
        return isCapture;
    }

    public String getPathSegment() {
        return pathSegment;
    }

    public void setPathSegment(String pathSegment) {
        this.pathSegment = pathSegment;
    }

    public RouteSegment getChildCapture() {
        return childCapture;
    }

    public void setChildCapture(RouteSegment childCapture) {
        this.childCapture = childCapture;
    }

    public RouteSegment getChild(String pathSegment) {
        return null;
    }

    public RouteHandler getHandler() {
        return handler;
    }

    public void setHandler(RouteHandler handler) {
        this.handler = handler;
    }

    public void extend(RouteSegment routeSegment) {
        if (routeSegment.isCapture) {
            setChildCapture(routeSegment);
        } else {
            children.put(routeSegment.getPathSegment(), routeSegment);
        }
    }
}
