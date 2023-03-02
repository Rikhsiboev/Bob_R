package com.bob_r.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class studentController {
    @RequestMapping("/welcome")
    public String homePage(Model model) {
        // model interface
        model.addAttribute("name","Course");
        model.addAttribute("course","Abc");
        return "/student/welcome";
    }
}
