package com.Bob_R.mapper;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    private ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Role convertToEntity(RoleDTO dto){
    return modelMapper.map(dto,Role.class);
    }
    public RoleDTO convertToDto(Role entity){
    return modelMapper.map(entity,RoleDTO.class);
    }
}