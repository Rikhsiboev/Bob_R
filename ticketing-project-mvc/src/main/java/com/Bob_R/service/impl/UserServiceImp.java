package com.Bob_R.service.impl;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO user) {

        return super.save(user.getUserName(), user);

    }

    @Override
    public UserDTO findById(String username) {
        return super.findById(username);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String username) {
        super.deleteById(username);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream().filter(user -> user.getRole().getId() == 2).collect(Collectors.toList());
    }
}
