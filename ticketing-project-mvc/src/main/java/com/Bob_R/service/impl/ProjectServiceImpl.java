package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.Project;
import com.Bob_R.entity.User;
import com.Bob_R.enums.Status;
import com.Bob_R.mapper.ProjectMapper;
import com.Bob_R.mapper.UserMapper;
import com.Bob_R.repository.ProjectRepository;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.TaskService;
import com.Bob_R.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserService userService;
    private final UserMapper userMapper;
    private final TaskService taskService;


    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper, UserService userService, UserMapper userMapper, TaskService taskService) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO getByProjectCode(String code) {
        return projectMapper.convertToDto(projectRepository.findByProjectCode(code));
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
        Project project = projectRepository.findByProjectCode(dto.getProjectCode());
        Project convert = projectMapper.convertToEntity(dto);
        convert.setId(project.getId());
        convert.setProjectStatus(project.getProjectStatus());
        projectRepository.save(convert);

    }

    @Override
    public void delete(String code) {
        Project project = projectRepository.findByProjectCode(code);
        project.setIsDeleted(true);
        project.setProjectCode(project.getProjectCode() + "-" + project.getId());  // if code SP00 after this code will be SP00-1 as unique
        projectRepository.save(project);
        taskService.deleteByProject(projectMapper.convertToDto(project)); // to make sure task also from project delete but saved in db
    }

    @Override
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);

    }

    @Override
    public List<ProjectDTO> listAllProjectsDetails() {
        UserDTO currentUserDto = userService.findByUserName("harold@manager.com");
        User user = userMapper.convertToEntity(currentUserDto);


        List<Project> list = projectRepository.findByAssignedManager(user);


        return list.stream().map(project -> {
            ProjectDTO obj = projectMapper.convertToDto(project);
            obj.setUnfinishedTaskCounts(taskService.totalNonCompletedTask(project.getProjectCode()));
            obj.setCompleteTaskCounts(taskService.totalCompletedTask(project.getProjectCode()));
            return obj;
        }).collect(Collectors.toList());
    }
}
