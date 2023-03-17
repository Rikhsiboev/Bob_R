package com.Bob_R.service;

import com.Bob_R.dto.TaskDTO;
import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long>{

    List<TaskDTO> findTasksByManager (UserDTO manager);

}
