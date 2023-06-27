package com.bob_r.repository;

import com.bob_r.entity.Project;
import com.bob_r.entity.User;
import com.bob_r.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectCode(String code);
    List<Project> findAllByAssignedManager(User manager);
    List<Project> findAllByProjectStatusIsNotAndAssignedManager(Status status, User assignedManager);

}
