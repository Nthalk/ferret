package com.iodesystems.ferret.route;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RouterTest {
    @Test
    public void name() throws Exception {
        Router router = new Router();
        router.extend("GET", "/locations/:locationId", new RouteHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response) {
            }
        });
        System.out.printf("");
    }

}
