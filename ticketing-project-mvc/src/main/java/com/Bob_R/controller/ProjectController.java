package com.Bob_R.controller;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }


    @GetMapping("/create")
    public String projectCreate(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("manager", userService.findAll());
        model.addAttribute("projects",projectService.findAll());


        return "/project/create";
    }
}
