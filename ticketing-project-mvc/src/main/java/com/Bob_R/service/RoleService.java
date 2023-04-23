package com.Bob_R.service;

import com.Bob_R.dto.RoleDTO;

import java.util.List;

public interface RoleService {

   List<RoleDTO> listAllRoles();
   RoleDTO findById(Long id);
}
