package com.bob_r.controller;

import com.bob_r.nodel.Mentor;
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
public class mentorController {


    @GetMapping("/register") //localhost8080/register
    public String register(Model model) {
        List<String> batchlist = Arrays.asList("JD1", "JD2", "JD3");
        model.addAttribute("batchList", batchlist);
        model.addAttribute("mentor", new Mentor());

        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor, Model model) {


        // How i can access to mentor attribute in this method

//        return "mentor/mentor-register";
//        return "mentor/mentor-confirmation";

        return "redirect:/mentor/register";
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
