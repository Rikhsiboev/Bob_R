package com.Bob_R.controller;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.RoleService;
import com.Bob_R.service.impl.RoleServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user", new UserDTO());
//        model.addAttribute("roles", new RoleServiceImp());
        return "/user/create";
    }

}
