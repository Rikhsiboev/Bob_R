package com.Bob_R.mapper;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User convertToEntity(UserDTO userDTO){
        return modelMapper.map(userDTO,User.class);
    }
    public UserDTO convertToDTO(User userEntity){
        return modelMapper.map(userEntity,UserDTO.class);
    }
}
