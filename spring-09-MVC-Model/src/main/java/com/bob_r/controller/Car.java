package com.bob_r.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

@Controller
public class Car {
   @RequestMapping ("/info")
    public String carInfo(@RequestParam String make,Model model){

      model.addAttribute("make",make);


        return "/car/car-info";
    }
}
