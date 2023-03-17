package com.Bob_R.controller;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/create")
    public String taskCreate(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("task", new TaskDTO());


        return "/task/create";
    }

}
