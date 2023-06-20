package com.bob_R.service;

import com.bob_R.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
