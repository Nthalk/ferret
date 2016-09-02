package com.iodesystems.ferret.route;

import com.iodesystems.ferret.xsd.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Router {
    final List<Route> routes;

    @Autowired
    public Router(List<Route> routes) {
        this.routes = routes;
    }
}
