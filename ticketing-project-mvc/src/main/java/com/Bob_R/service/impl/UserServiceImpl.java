package com.Bob_R.service.impl;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.TaskDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.entity.User;
import com.Bob_R.mapper.UserMapper;
import com.Bob_R.repository.UserRepository;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.TaskService;
import com.Bob_R.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProjectService projectService;
    private final TaskService taskService;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, @Lazy ProjectService projectService, @Lazy TaskService taskService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @Override
    public List<UserDTO> listAllUsers() {

        List<User> userList = userRepository.findAll(Sort.by("firstName"));
        return userList.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {

        User user = userRepository.findByUserName(username);
        return userMapper.convertToDTO(user);
    }

    @Override
    public void save(UserDTO user) {
        userRepository.save(userMapper.convertToEntity(user));
    }

//    @Override // this is for hard deleting
//    public void deleteByUserName(String username) {
//        userRepository.deleteByUserName(username);
//    }

    @Override
    public UserDTO update(UserDTO user) {

        //Find current user
        User user1 = userRepository.findByUserName(user.getUserName());  //has id
        //Map update user dto to entity object
        User convertedUser = userMapper.convertToEntity(user);   // has id?
        //set id to the converted object
        convertedUser.setId(user1.getId());
        //save the updated user in the db
        userRepository.save(convertedUser);

        return findByUserName(user.getUserName());

    }

    @Override
    public void delete(String username) {

        User user = userRepository.findByUserName(username);

        if (checkIfUserCanBeDeleted(user)){
            user.setIsDeleted(true);
            user.setUserName(user.getUserName()+" - " + user.getId()); //=> if i deleted +> harol@manager.com - 2
            userRepository.save(user);
        }

    }

    @Override
    public List<UserDTO> listAllByRole(String role) {

        List<User> users = userRepository.findByRoleDescriptionIgnoreCase(role);

        return users.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }


    private boolean checkIfUserCanBeDeleted(User user) {
        switch (user.getRole().getDescription()) {
            case "Manager":
                    List<ProjectDTO> projectDTOList = projectService.listAllNonCompletedByAssignedManager(userMapper.convertToDTO(user));
                    return  projectDTOList.size()==0;
            case "Employee":
                List<TaskDTO> TaskDTOList = taskService.listAllNonCompletedByAssignedEmployee(userMapper.convertToDTO(user));
                return  TaskDTOList.size()==0;
            default:
                return true;
        }
    }


}
