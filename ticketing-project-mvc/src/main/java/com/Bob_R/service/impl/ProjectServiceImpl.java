package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.entity.Project;
import com.Bob_R.entity.User;
import com.Bob_R.enums.Status;
import com.Bob_R.mapper.ProjectMapper;
import com.Bob_R.repository.ProjectRepository;
import com.Bob_R.service.ProjectService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return null;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {

        List<Project> list = projectRepository.findAll(Sort.by("projectCode"));

        return list.stream().map(projectMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO dto) {

        dto.setProjectStatus(Status.OPEN);
        Project project = projectMapper.convertToEntity(dto);
        projectRepository.save(project);
    }


    @Override
    public void update(ProjectDTO dto) {

    }

    @Override
    public void delete(String code) {

        Project project = projectRepository.findByProjectCode(code);
        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(String projectCode) {

    }
}
