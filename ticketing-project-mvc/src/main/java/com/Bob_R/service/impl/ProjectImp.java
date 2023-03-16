package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.enums.Status;
import com.Bob_R.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectImp extends AbstractMapService <ProjectDTO,String>  implements ProjectService {


    @Override
    public ProjectDTO save(ProjectDTO project) {

        if(project.getProjectStatus()==null)
            project.setProjectStatus(Status.OPEN);

        return super.save(project.getProjectCode(),project);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO object) {
        super.update(object.getProjectCode(),object);
    }


}
