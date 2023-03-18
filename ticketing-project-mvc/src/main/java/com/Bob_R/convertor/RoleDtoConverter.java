package com.Bob_R.convertor;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String, RoleDTO> {  // String 2
    RoleService roleService;

    public RoleDtoConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {
        if(source==null||source.equals("")){  // select ->""
            return null;
        }
        return roleService.findById(Long.parseLong(source));
    }
}
