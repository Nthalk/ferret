package com.iodesystems.ferret.route;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class RouteHandler {
    public abstract void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
