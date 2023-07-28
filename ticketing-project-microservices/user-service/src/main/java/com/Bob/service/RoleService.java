package com.Bob.service;

import com.Bob.dto.RoleDTO;
import com.Bob.exception.UserServiceException;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id) throws UserServiceException;
}
