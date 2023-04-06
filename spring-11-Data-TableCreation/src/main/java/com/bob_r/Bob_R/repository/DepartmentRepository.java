package com.bob_r.Bob_R.repository;

import com.bob_r.Bob_R.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
