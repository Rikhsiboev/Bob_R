package com.Bob_R.repository;

import com.Bob_R.entity.Project;
import com.Bob_R.entity.User;
import com.Bob_R.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectCode(String code);
    List<Project> findByAssignedManager(User manager);
    List<Project> findAllByProjectStatusIsNotAndAssignedManager(Status status,User assignedManager);

}
