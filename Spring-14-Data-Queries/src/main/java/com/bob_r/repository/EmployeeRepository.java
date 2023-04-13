package com.bob_r.repository;

import com.bob_r.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee,Integer>{

    //Display all employees with email address
    List<Employee> findByEmail(String emails);
    //Display all employees with firstname "" and last name ""
    //also show all employees with  an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String FirstName,String LastName, String Email);
    //Display all employees that first name is not
    List<Employee> findByFirstNameIs(String name);
    // Display all employees where last name stars with
    List<Employee> findByLastNameStartingWith(String name);
    //Display all employees with salaries higher than
    List<Employee> findBySalaryGreaterThanEqual(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);
    // Display all employees that has been≈ hired between "" and  "" ≈
    List<Employee> findByHireDateBetween(LocalDate start,LocalDate endDate);

    // Display top unique 3 employees that is making less than
    List<Employee> findDistinctTop3BySalaryLessThanEqual(Integer integer);
    //Display all employee they do not have emails address
    List<Employee> findByEmailIsNull();

    @Query("select employee from Employee employee where employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();
}
