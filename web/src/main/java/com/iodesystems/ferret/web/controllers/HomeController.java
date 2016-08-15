package com.iodesystems.ferret.web.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@RequestMapping("/")
public class HomeController {
    @RequestMapping(name = "home", method = RequestMethod.GET)
    public String index() {
        return "home";
    }
}
