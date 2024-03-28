package com.company.controller;

import com.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String mentorRegister(Model model) {

        List<String> batchList = Arrays.asList("JD1", "JD2", "B18", "B20", "EU1", "EU2");
        Mentor mentor = new Mentor();
        //  mentor.setFirstName("Joe");

        model.addAttribute("mentor", mentor);
        model.addAttribute("batchList", batchList);

        return "mentor/register";
    }

    @PostMapping("/confirm")
    public String mentorConfirm(@ModelAttribute("mentor") Mentor mentor) {
      System.out.println(mentor.toString());
      //  return "mentor/confirmation";
        return "redirect:/mentor/register";  // redirect!
    }
}
