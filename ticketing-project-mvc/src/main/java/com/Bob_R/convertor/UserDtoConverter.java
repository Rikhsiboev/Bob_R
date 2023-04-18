package com.Bob_R.convertor;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.UserService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component

public class UserDtoConverter implements Converter<String, UserDTO> {
    UserService userService;

    public UserDtoConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        if (source==null||source.equals("")){
            return null;
        }
        return userService.findByUserName(source);
    }
}
