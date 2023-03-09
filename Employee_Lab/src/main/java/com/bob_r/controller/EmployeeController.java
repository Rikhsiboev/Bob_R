package com.bob_r.controller;

import com.bob_r.bootsrap.DataGenerator;
import com.bob_r.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/register")
    public String createEmployee(Model model) {
        model.addAttribute("employee",new Employee());
        model.addAttribute("stateList", DataGenerator.getAllState());
        return "employee/employee-create";
    }
}
