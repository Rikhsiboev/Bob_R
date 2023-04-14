package com.bob_r;

import com.bob_r.repository.DepartmentRepository;
import com.bob_r.repository.EmployeeRepository;
import com.bob_r.repository.RegionRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("<<<<<<<<<<<<<<<<<<<Regions>>>>>>>>>>>>>>>>>");
        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegionDesc:" + regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("<<<<<<<<<<<<<<<<<<<Department>>>>>>>>>>>>>>>>>");
        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("findByDivisionIsEndingWith:" + departmentRepository.findByDivisionIsEndingWith("ics"));

        System.out.println("<<<<<<<<<<<<<<<<<<<EMPLOYEE>>>>>>>>>>>>>>>>>");
        System.out.println("findByEmail" + employeeRepository.findByEmail("bob@gmail.com"));
        System.out.println("findByFirstNameAndLastNameAndEmail" + employeeRepository.findByFirstNameAndLastNameOrEmail("Bob", "R", "Rikhs@gmail.com"));
        System.out.println("findByFirstNameIsNot" + employeeRepository.findByFirstNameIsNot("Berrie"));
        System.out.println("findByLastNameStartsWith" + employeeRepository.findByLastNameStartsWith("Bob"));
        System.out.println("<<<<<<<<<<<<<<<<<<<EMPLOYEE 2>>>>>>>>>>>>>>>>>");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
    }
}
