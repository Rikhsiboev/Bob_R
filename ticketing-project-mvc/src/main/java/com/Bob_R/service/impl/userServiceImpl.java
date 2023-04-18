package com.Bob_R.service.impl;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userServiceImpl implements UserService {
    @Override
    public List<UserDTO> listAllUsers() {
        return null;
    }

    @Override
    public UserDTO findByUserName(String username) {
        return null;
    }

    @Override
    public void save(UserDTO userDTO) {

    }

    @Override
    public void deleteByUserName(String username) {

    }
}
