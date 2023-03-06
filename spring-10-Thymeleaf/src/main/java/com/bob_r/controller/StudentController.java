package com.bob_r.controller;

import com.bob_r.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping(value = "register", method = RequestMethod.GET) //localhost8080/student/register
    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("students", DataGenerator.createStudent());


        return "student/register";
    }

    @RequestMapping(value = "/drop", method=RequestMethod.POST) //localhost8080/student/map
    @PostMapping("/drop")
    public String drop() {
        return "student/register";
    }

    //
//    @RequestMapping("welcome") //localhost8080/student/welcome
//    public String welcome(){
//
//        return "student/welcome";
//    }
//    @RequestMapping("welcome") //localhost8080/student/welcome
//    public String welcome(@RequestParam int id){
//        System.out.println(id);
//        return "student/welcome";
//    }
    @RequestMapping("welcome") //localhost8080/student/welcome
    public String welcome(@RequestParam String name) {
        System.out.println(name);
        return "student/welcome";
    }
}
