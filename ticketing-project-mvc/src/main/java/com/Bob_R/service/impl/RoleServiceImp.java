package com.Bob_R.service.impl;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.service.RoleService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // like @Component - creates bean
public class RoleServiceImp extends AbstractMapService <RoleDTO,Long> implements RoleService {


    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return super.save(roleDTO.getId(),roleDTO);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(),object);
    }
}
