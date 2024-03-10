package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping("/welcome")
    public String homePage(Model model) {
        model.addAttribute("name", "Artur");
        model.addAttribute("course", "MVC");

        String subject = "Collections";
        model.addAttribute("subject", subject);

        int studentId = new Random().nextInt(500, 1000);
        model.addAttribute("studentId", studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);
        numbers.add(9);

        model.addAttribute("numbers", numbers);

        return "student/welcome";
    }

    @RequestMapping("/")
    public String homePage2(Model model) {

        return "student/welcome";
    }
}
