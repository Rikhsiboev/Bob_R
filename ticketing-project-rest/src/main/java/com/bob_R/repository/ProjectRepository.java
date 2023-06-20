package com.bob_R.repository;

import com.bob_R.entity.Project;
import com.bob_R.entity.User;
import com.bob_R.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectCode(String code);
    List<Project> findAllByAssignedManager(User manager);
    List<Project> findAllByProjectStatusIsNotAndAssignedManager(Status status, User assignedManager);

}
