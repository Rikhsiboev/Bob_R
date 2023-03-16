package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectImp extends AbstractMapService <ProjectDTO,String>  implements ProjectService {


    @Override
    public ProjectDTO save(ProjectDTO project) {
        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String  projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {
    super.deleteById(projectCode);
    }

    @Override
    public void update(ProjectDTO project) {
        super.update(project.getProjectCode(),project);
    }
}
