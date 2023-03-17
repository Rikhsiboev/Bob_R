package com.Bob_R.service.impl;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.enums.Status;
import com.Bob_R.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImp extends AbstractMapService <TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO task) {
        if(task.getTaskStatus()==null) {
            task.setTaskStatus(Status.OPEN);
        }
        if (task.getAssignedDate()==null){
            task.setAssignedDate(LocalDate.now());
        }
        if (task.getId()==null){
            task.setId(UUID.randomUUID().getMostSignificantBits());
        }
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
