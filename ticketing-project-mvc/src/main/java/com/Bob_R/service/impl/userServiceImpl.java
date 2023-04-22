package com.Bob_R.service.impl;

import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.User;
import com.Bob_R.mapper.UserMapper;
import com.Bob_R.repository.UserRepository;
import com.Bob_R.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public userServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {

        List<User> userList = userRepository.findAll(Sort.by("FistName"));
        return userRepository.findAll().stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return userMapper.convertToDTO(userRepository.findByUserName(username));
    }

    @Override
    public void save(UserDTO userDTO) {
        userRepository.save(userMapper.convertToEntity(userDTO));
    }

    @Override
    public void deleteByUserName(String username) {

    }

    @Override
    public UserDTO update(UserDTO user) {
        //  Find current user
        User user1 = userRepository.findByUserName(user.getFirstName());
        // map update user dto to entity object
        User convertedUser = userMapper.convertToEntity(user);
        // set id tp converted object
        convertedUser.setId(user1.getId());
        // save the update user in the db
       userRepository.save(convertedUser);
       return findByUserName(user.getFirstName());
    }
}
