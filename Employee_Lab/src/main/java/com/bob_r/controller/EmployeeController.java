package com.bob_r.controller;

import com.bob_r.bootsrap.DataGenerator;
import com.bob_r.model.Employee;
import com.bob_r.service.EmployeeService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    // dependency injection
    private final EmployeeService employeeService;

    //constructor to create object
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model) {
        ///new Employee
        model.addAttribute("employee", new Employee());
        // from DataGenerator
        model.addAttribute("stateList", DataGenerator.getAllState());
        return "employee/employee-create";
    }

    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") Employee employee) {
        //saving employer
        employeeService.saveEmployee(employee);
        //return as redirect to list @GetMapping("/list")

        return "redirect:/employee/list";
    }


    @GetMapping("/list")
    public String listEmployees(Model model) {

        // and showing of list
        model.addAttribute("employeeList", employeeService.readAllEmployees());
        return "employee/employee-list";  // we are using html with redirect
    }
}
