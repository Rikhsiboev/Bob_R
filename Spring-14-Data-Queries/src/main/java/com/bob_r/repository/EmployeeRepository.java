package com.bob_r.repository;

import com.bob_r.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

    //Display all employees with email address
    List<Employee> findByEmail(String emails);
    //Display all employees with firstname "" and last name ""
    //also show all employees with  an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String FirstName,String LastName, String Email);
    //Display all employees that first name is not
    List<Employee> findByFirstNameIsNot(String name);
    // Display all employees where last name stars with
    List<Employee> findByLastNameStartingWith(String name);
    //Display all employees with salaries higher than
    List<Employee> findBySalaryGreaterThanEqual(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);
//
}
