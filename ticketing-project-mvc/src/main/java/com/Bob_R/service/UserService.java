package com.Bob_R.service;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.exception.TicketingProjectException;

import java.util.List;

public interface UserService {
    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);
    void save(UserDTO user);
//    void deleteByUserName(String username); // hard code for deleting service => repo
    UserDTO update(UserDTO user);
    void delete(String username) throws TicketingProjectException;
    List<UserDTO> listAllByRole(String role);

}
