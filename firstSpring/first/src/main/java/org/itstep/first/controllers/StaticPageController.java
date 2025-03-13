package org.itstep.first.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {

    @GetMapping("/about")
    public String about() {
        return "pages/about";
    }

    @GetMapping("/")
    public String home() {
        return "pages/home";
    }


    @GetMapping("/contact")
    public String contact() {
        return "pages/contact";
    }
}
