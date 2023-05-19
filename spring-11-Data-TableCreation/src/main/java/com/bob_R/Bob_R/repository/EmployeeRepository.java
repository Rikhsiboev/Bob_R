package com.bob_R.Bob_R.repository;

import com.bob_R.Bob_R.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
