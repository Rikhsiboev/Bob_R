package com.Bob_R.controller;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.enums.Status;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.TaskService;
import com.Bob_R.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }


    @GetMapping("/create")
    public String taskCreate(Model model) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("employees", userService.listAllByRole("employee"));
        model.addAttribute("tasks", taskService.listAllTask());
        return "/task/create";
    }
    @PostMapping("/create")
    public String insertTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("projects", projectService.listAllProjects());
            model.addAttribute("employees", userService.listAllByRole("employee"));
            model.addAttribute("tasks", taskService.listAllTask());

            return "/task/create";

        }

        taskService.save(task);

        return "redirect:/task/create";

    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.delete(id);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask( @PathVariable("taskId") Long taskId, Model model) {
        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.listAllProjects());
        model.addAttribute("employees", userService.listAllByRole("employee"));
        model.addAttribute("tasks", taskService.listAllTask());

        return "/task/update";
    }
    @PostMapping("/update/{id}")
    public String updateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("projects", projectService.listAllProjects());
            model.addAttribute("employees", userService.listAllByRole("employee"));
            model.addAttribute("tasks", taskService.listAllTask());

            return "/task/update";

        }


        taskService.update(task);

        return "redirect:/task/create";

    }

    @GetMapping("/employee/pending-tasks")
    public String pendingTask(Model model) {
        model.addAttribute("tasks", taskService.listAllTasksByStatusIsNot(Status.COMPLETE));
        return "/task/pending-tasks";
    }




    @GetMapping("/employee/archive")
    public String archive(Model model) {
        model.addAttribute("tasks", taskService.listAllTasksByStatus(Status.COMPLETE));
        return "/task/archive";
    }

    @GetMapping("/employee/edit/{id}")
    public String updatePendingTask(@PathVariable("id") Long task,Model model) {
        model.addAttribute("task", taskService.findById(task));
//        model.addAttribute("projects",projectService.findAll());    /// ===> in MVC
//        model.addAttribute("employees",userService.findEmployees());

        model.addAttribute("statuses",Status.values());
        model.addAttribute("tasks",taskService.listAllTasksByStatusIsNot(Status.COMPLETE));
        return "/task/status-update";
    }

    @PostMapping("/employee/update/{id}")
    public String employeeUpdateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("statuses", Status.values());
            model.addAttribute("tasks", taskService.listAllTasksByStatusIsNot(Status.COMPLETE));

            return "/task/status-update";

        }

        taskService.update(task);

        return "redirect:/task/employee/pending-tasks";

    }

}
