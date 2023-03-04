package com.bob_r.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/mentor")
public class mentorController {

    @RequestMapping("/register") //localhost8080/register
    public String register(){
        return "student/register";
    }
    @RequestMapping("/drop") //localhost8080/mentor/drop
    public String drop(){
        return "mentor/register";
    }
}
