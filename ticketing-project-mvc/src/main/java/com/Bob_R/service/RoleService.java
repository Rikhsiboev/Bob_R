package com.Bob_R.service;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.entity.Role;

import java.util.List;

public interface RoleService {
   List <RoleDTO> listAllRole();
   RoleDTO findById(Long id);
}
