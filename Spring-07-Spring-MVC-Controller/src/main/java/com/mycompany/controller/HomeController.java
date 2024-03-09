package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Annotate the class with @Controller stereotype annotation
public class HomeController {
    @RequestMapping("/home") // Used to associate action with HTTP request path
    public String home() {
        return "home.html";   // return HTML doc name that contains details we want to display
    }

    @RequestMapping("/welcome")
    public String home2() {
        return "welcome.html";
    }

    @RequestMapping("/")
    public String home3() {
        return "welcome.html";
    }


}
