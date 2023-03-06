package com.bob_r.controller;

import com.bob_r.nodel.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/mentor")
public class mentorController {


    @GetMapping("/register") //localhost8080/register
    public String register(Model model){
        model.addAttribute("mentor",new Mentor());

        return "mentor/mentor-register";
    }


//    @RequestMapping("/register") //localhost8080/register
//    public String register(){
//        return "student/register";
//    }




//    @RequestMapping("/drop") //localhost8080/mentor/drop
//    public String drop(){
//        return "mentor/register";
//    }
}
