package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.web.models.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{path}")
    public String page(@PathVariable String path,
                       @ModelAttribute Page page) {
        return "page";
    }
}
