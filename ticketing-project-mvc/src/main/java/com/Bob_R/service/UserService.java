package com.Bob_R.service;

import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService <UserDTO,String> {

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
