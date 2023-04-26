package com.Bob_R.service;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.UserDTO;
import org.hibernate.validator.constraints.Email;

import java.util.List;

public interface ProjectService {
    ProjectDTO getByProjectCode(String code);
    List<ProjectDTO> listAllProjects();
    void save(ProjectDTO dto);
    void update(ProjectDTO dto);
    void delete(String code);
    void complete(String projectCode);


}
