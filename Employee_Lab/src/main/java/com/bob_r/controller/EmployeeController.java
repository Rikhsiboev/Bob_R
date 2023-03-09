package com.bob_r.controller;

import com.bob_r.bootsrap.DataGenerator;
import com.bob_r.model.Employee;
import com.bob_r.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String createEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("stateList", DataGenerator.getAllState());
        return "employee/employee-create";
    }
    @PostMapping("/insert")
    public String insertEmployee(@ModelAttribute("employee") Employee employee){

    employeeService.saveEmployee(employee);
    return "employee/employee-list";

    }
}
