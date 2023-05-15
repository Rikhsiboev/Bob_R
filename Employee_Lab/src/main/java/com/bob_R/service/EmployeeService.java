package com.bob_R.service;

import com.bob_R.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {
    public static List<Employee> employeeList = new ArrayList<>();
    public void saveEmployee(Employee employee){
        employeeList.add(employee);
    }
    public List<Employee> readAllEmployees(){
        return employeeList;
    }
}
