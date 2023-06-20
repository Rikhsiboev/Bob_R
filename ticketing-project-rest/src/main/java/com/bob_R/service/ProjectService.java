package com.bob_R.service;

import com.bob_R.dto.ProjectDTO;
import com.bob_R.dto.UserDTO;

import java.util.List;

public interface ProjectService {

    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String code);
    void complete(String code);
    List<ProjectDTO> listAllProjectDetails();

    List<ProjectDTO> listAllNonCompletedByAssignedManager(UserDTO assignedManager);

}
