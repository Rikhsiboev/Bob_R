package com.bob_r.controller;

import com.bob_r.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("register") //localhost8080/student/register
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());


        return "student/register";
    }

    @RequestMapping("drop") //localhost8080/student/map
    public String drop(){
        return "student/register";
    }


    @RequestMapping("welcome") //localhost8080/student/welcome
    public String welcome(){

        return "student/welcome";
    }


}
