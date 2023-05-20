package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.TaskDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.Project;
import com.Bob_R.entity.Task;
import com.Bob_R.entity.User;
import com.Bob_R.enums.Status;
import com.Bob_R.mapper.ProjectMapper;
import com.Bob_R.mapper.TaskMapper;
import com.Bob_R.mapper.UserMapper;
import com.Bob_R.repository.TaskRepository;
import com.Bob_R.service.TaskService;
import com.Bob_R.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ProjectMapper projectMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    public TaskServiceImp(TaskRepository taskRepository, TaskMapper taskMapper, ProjectMapper projectMapper, @Lazy UserService userService, UserMapper userMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.projectMapper = projectMapper;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public TaskDTO findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(taskMapper::convertToDTO).orElse(null);
    }

    @Override
    public List<TaskDTO> listAllTask() {
        return taskRepository.findAll().stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO dto) { //
        dto.setTaskStatus(Status.OPEN);
        dto.setAssignedDate(LocalDate.now());
        Task task = taskMapper.convertToEntity(dto);
        taskRepository.save(task);
    }

    @Override
    public void update(TaskDTO dto) {
        Optional<Task> task = taskRepository.findById(dto.getId());
        Task convertedTask = taskMapper.convertToEntity(dto);
        if (task.isPresent()) {   // we need more information from db to show in List
            convertedTask.setTaskStatus(dto.getTaskStatus() == null ? task.get().getTaskStatus() : dto.getTaskStatus()); // if condition to check is it coming from new page or from complete page project
            convertedTask.setAssignedDate(task.get().getAssignedDate());
            taskRepository.save(convertedTask);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Task> foundTask = taskRepository.findById(id);
        if (foundTask.isPresent()) { /// condition of delete and show on list
            foundTask.get().setIsDeleted(true); // but save this task in DB
            taskRepository.save(foundTask.get());
        }
    }


    @Override
    public int totalNonCompletedTask(String projectCode) {
        return taskRepository.totalNonCompletedTasks(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTasks(projectCode);
    }

    @Override
    public void deleteByProject(ProjectDTO projectDTO) {  /// deleting project but this method for task deleting at same time
        Project project = projectMapper.convertToEntity(projectDTO); //converting project to Entity from DTO
        List<Task> tasks = taskRepository.findAllByProject(project); // from DB
        tasks.forEach(task -> delete(task.getId()));// deleting each of them by id by using delete method ahead
    }

    @Override
    public void completeByProject(ProjectDTO projectDTO) {/// complete project but this method for task complete at same time
        Project project = projectMapper.convertToEntity(projectDTO); //convert
        List<Task> tasks = taskRepository.findAllByProject(project); // find from task Data Base
        tasks.stream().map(taskMapper::convertToDTO).forEach(taskDTO -> {     //converting and bring them status complete and update method ahead
            taskDTO.setTaskStatus(Status.COMPLETE);
            update(taskDTO);
        });

    }

    @Override
    public List<TaskDTO> listAllTasksByStatusIsNot(Status status) {
        //we have to make sure which role in system from security and to show our projectionist
        //
        //from hard code to soft code
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserDTO loggedInUser = userService.findByUserName(username);
        List<Task> tasks = taskRepository.findAllByTaskStatusIsNotAndAssignedEmployee(status, userMapper.convertToEntity(loggedInUser));
        return tasks.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> listAllTasksByStatus(Status status) {
         //we have to make sure which role in system from security and to show our projectionist
        //
        //from hard code to soft code
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserDTO loggedInUser = userService.findByUserName(username);
        List<Task> tasks = taskRepository.findAllByTaskStatusAndAssignedEmployee(status, userMapper.convertToEntity(loggedInUser));
        return tasks.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }


    @Override
    public List<TaskDTO> listAllNonCompletedByAssignedEmployee(UserDTO assignedEmployee) {
        List<Task> tasks = taskRepository.
                findAllByTaskStatusIsNotAndAssignedEmployee(Status.COMPLETE,userMapper.convertToEntity(assignedEmployee));
        return tasks.stream().map(taskMapper::convertToDTO).collect(Collectors.toList());

    }


}
