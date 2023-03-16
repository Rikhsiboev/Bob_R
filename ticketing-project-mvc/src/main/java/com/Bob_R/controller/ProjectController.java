package com.Bob_R.controller;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createProject(Model model){

        model.addAttribute("project",new ProjectDTO());

        model.addAttribute("managers",userService.findAll());

        model.addAttribute("projects",projectService.findAll());

        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project){


        projectService.save(project);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){

        projectService.deleteById(projectCode);

        return "redirect:/project/create";

    }
}
