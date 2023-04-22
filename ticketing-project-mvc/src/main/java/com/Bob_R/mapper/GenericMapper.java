//package com.Bob_R.mapper;
//
//import com.Bob_R.dto.RoleDTO;
//import com.Bob_R.entity.Role;
//import org.modelmapper.ModelMapper;
//
//import java.io.Serializable;
//public class GenericMapper<DTO, Entity> {
//    private final Class<DTO> dtoClass;
//    private final Class<Entity> entityClass;
//    private final ModelMapper modelMapper;
//
//    public GenericMapper(Class<DTO> dtoClass, Class<Entity> entityClass, ModelMapper modelMapper) {
//        this.dtoClass = dtoClass;
//        this.entityClass = entityClass;
//        this.modelMapper = modelMapper;
//    }
//
//    public Entity convertToEntity(DTO dto) {
//        return modelMapper.map(dto, entityClass);
//    }
//
//    public DTO convertToDto(Entity entity) {
//        return modelMapper.map(entity, dtoClass);
//    }
//}