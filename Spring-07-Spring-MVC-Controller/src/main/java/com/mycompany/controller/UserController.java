package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user() {
        return "user/userinfo.html";
    }

    @RequestMapping("/sample")
    public String user2() {
        return "homeSample.html";
    }

}
