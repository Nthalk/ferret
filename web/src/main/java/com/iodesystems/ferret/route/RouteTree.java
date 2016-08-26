package com.iodesystems.ferret.route;

import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.HashMap;
import java.util.Map;

public class RouteTree {

    Map<String, RouteTree> children = new HashMap<>();
    Option<Routeable> terminus = Option.empty();
    Option<Routeable> intermediate = Option.empty();
    private RouteTree capture;

    public Option<Routeable> getTerminus() {
        return terminus;
    }

    public Option<Routeable> getIntermediate() {
        return intermediate;
    }

    public void extend(Iterable<Routeable> routeablePath) {
        RouteTree current = this;
        for (Routeable lastRoutable : Fn.last(routeablePath)) {
            for (Routeable routeable : routeablePath) {
                for (String pathSegment : routeable.getPath()) {
                    RouteTree finalCurrent = current;
                    current = Fn.getOrAdd(current.getChildren(), pathSegment, () -> {
                        RouteTree routeTree = new RouteTree();
                        if (pathSegment.startsWith(":")) {
                            if (!hasCapture()) {
                                finalCurrent.setCapture(routeTree);
                            } else {
                                throw new RuntimeException("Duplicate capture");
                            }
                        }
                        return routeTree;
                    });
                }
                if (routeable == lastRoutable) {
                    current.terminus = Option.of(routeable);
                } else {
                    current.intermediate = Option.of(routeable);
                }
            }
        }
    }

    public Map<String, RouteTree> getChildren() {
        return children;
    }

    public RouteTree getCapture() {
        return capture;
    }

    public void setCapture(RouteTree capture) {
        this.capture = capture;
    }

    public boolean hasCapture() {
        return capture != null;
    }

    public Option<RouteTree> get(String part) {
        for (RouteTree routeTree : Fn.get(getChildren(), part)) {
            return Option.of(routeTree);
        }
        return Option.of(getCapture());
    }
}
