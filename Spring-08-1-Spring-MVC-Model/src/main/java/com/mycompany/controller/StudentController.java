package com.mycompany.controller;

import com.mycompany.model.Gender;
import com.mycompany.model.Mentor;
import com.mycompany.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
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

        Student student = new Student(1, "John", "Doe");
        model.addAttribute("student", student);

        return "student/welcome";
    }

    @RequestMapping("/")
    public String homePage2(Model model) {

        return "student/welcome";
    }


}
