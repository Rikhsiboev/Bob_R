package com.Bob_R.service.impl;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImp extends AbstractMapService <TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {
        return super.save(task.getId(),task);
    }

    @Override
    public TaskDTO findById(Long taskId) {
        return super.findById(taskId);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long taskId) {
    super.deleteById(taskId);
    }

    @Override
    public void update(TaskDTO object) {
        super.update(object.getId(), object);
    }
}
