package com.Bob_R.convertor;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.service.ProjectService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {
    ProjectService projectService;

    public ProjectDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        return projectService.getByProjectCode(source);
    }
}
