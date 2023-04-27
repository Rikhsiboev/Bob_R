package com.Bob_R.mapper;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.Task;
import com.Bob_R.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Component
public class TaskMapper {
    private final ModelMapper modelMapper;

    public TaskMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Task convertToEntity(TaskDTO dto){
        return modelMapper.map(dto,Task.class);
    }
    public TaskDTO convertToDTO(Task entity){
        return modelMapper.map(entity,TaskDTO.class);
    }
}
