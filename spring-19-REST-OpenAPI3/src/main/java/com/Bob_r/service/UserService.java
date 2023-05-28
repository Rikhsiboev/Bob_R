package com.Bob_r.service;

import com.Bob_r.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO create(UserDTO userDTO);

}
