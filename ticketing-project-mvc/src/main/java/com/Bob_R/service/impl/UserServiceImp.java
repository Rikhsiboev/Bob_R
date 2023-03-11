package com.Bob_R.service.impl;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.UserService;

import java.util.List;

public class UserServiceImp extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO findBYID(String username) {
        return super.findByID(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String username) {
        super.deleteById(username);
    }
}
