package com.Bob_R.service.impl;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {
    @Override
    public TaskDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTask() {
        return null;
    }

    @Override
    public void save(TaskDTO dto) {

    }

    @Override
    public void update(TaskDTO dto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void complete(Long Id) {

    }
}
