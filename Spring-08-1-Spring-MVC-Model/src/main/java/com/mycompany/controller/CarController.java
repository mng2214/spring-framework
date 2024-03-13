package com.mycompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")    //http://localhost:8080/car/car-info?make=BMW
    public String carInfo(@RequestParam String make, @RequestParam String year, Model model) {
        System.out.println(make);
        System.out.println(year);
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "/car/car-info";
    }

    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "tesla") String make, Model model) {
        System.out.println(make);
        model.addAttribute("make", make);
        return "/car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")   //http://localhost:8080/car/info/honda
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year, Model model) {
        System.out.println(make);
        System.out.println(year);
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "/car/car-info";
    }

}
