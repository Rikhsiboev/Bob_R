package com.bob_r.converter;

import com.bob_r.dto.ProjectDTO;
//import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import com.bob_r.service.ProjectService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {


    ProjectService projectService;

    public ProjectDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {

        if (source == null || source.equals("")) {
            return null;
        }

        return projectService.getByProjectCode(source);

    }

}
