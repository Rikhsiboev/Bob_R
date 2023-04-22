package com.Bob_R.service;

import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);
    void save (UserDTO userDTO);
    void deleteByUserName(String username);
    UserDTO update(UserDTO user);
}
