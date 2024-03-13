package com.mycompany.controller;

import com.mycompany.model.Gender;
import com.mycompany.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/another")
public class AnotherController {
    @RequestMapping("/list")
    public String mentor(Model model) {

        Mentor mentor1 = new Mentor("John", "Doe", 30, Gender.MALE);
        Mentor mentor2 = new Mentor("Mike", "Smith", 25, Gender.MALE);
        Mentor mentor3 = new Mentor("Ammy", "Bryan", 27, Gender.FEMALE);

        List<Mentor> mentors = Arrays.asList(mentor1, mentor2, mentor3);

        model.addAttribute("mentors",mentors);

        return "mentor/list";
    }

}
