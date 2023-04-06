package com.bob_r.Bob_R.repository;

import com.bob_r.Bob_R.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
