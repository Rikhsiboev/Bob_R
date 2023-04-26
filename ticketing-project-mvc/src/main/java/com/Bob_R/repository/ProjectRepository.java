package com.Bob_R.repository;

import com.Bob_R.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectCode(String code);


}
