package com.Bob_R.service.impl;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.service.RoleService;

import java.util.List;

public class RoleServiceImp extends AbstractMapService <RoleDTO,Long> implements RoleService {
    @Override
    public RoleDTO save(RoleDTO role) {
        return super.save(role.getId(), role);
    }

    @Override
    public RoleDTO findBYID(Long id) {
        return super.findByID(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
