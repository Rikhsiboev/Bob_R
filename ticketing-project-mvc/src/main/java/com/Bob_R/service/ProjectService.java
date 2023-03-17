package com.Bob_R.service;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService <ProjectDTO,String> {

    void complete(ProjectDTO project);

    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager);


}
