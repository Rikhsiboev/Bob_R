package com.Bob_R.service;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO findById(Long id);
    List<TaskDTO> listAllTask();
    void save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(Long id);

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);




}
