package com.bob_r.repository;

import com.bob_r.Entity.Department;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all department i the Furniture Department
    List<Department> findByDepartment(String furniture);
    //Display all department in the Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    // Display all departments with division name ends with 'ics'
    List<Department> findByDivisionIsEndingWith(String name);
    // Display top 3 departments with division name includes Hea without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String name);

    @Query("select d from Department d where d.division IN = ?1 ")
    List<Department> retrieveDepartmentDivision(List<String> division);


}
