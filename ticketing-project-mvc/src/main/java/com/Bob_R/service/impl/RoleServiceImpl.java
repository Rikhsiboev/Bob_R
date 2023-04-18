package com.Bob_R.service.impl;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.entity.Role;
import com.Bob_R.repository.RoleRepository;
import com.Bob_R.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> listAllRole() {

        List<Role> roleList = roleRepository.findAll();
        return roleList;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }
}
