package com.Bob_R.controller;

import com.Bob_R.dto.ResponseWrapper;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getUsers() {
        List<UserDTO> getAllUSer = userService.listAllUsers();
        return ResponseEntity.ok(
                new ResponseWrapper("Users are successfully retrieves",
                        getAllUSer, HttpStatus.OK));
    }

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getUsersName(@PathVariable("username") String username) {
        UserDTO byUserName = userService.findByUserName(username);
        return ResponseEntity.ok(new ResponseWrapper("UserName are successfully retrieves",
                byUserName, HttpStatus.OK));

    }

    @PostMapping()
    public ResponseEntity<ResponseWrapper> createUsers(@RequestBody UserDTO user) {
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseWrapper("New User created and successfully retrieves",
                        HttpStatus.CREATED));
    }
    @PutMapping()
    public ResponseEntity<ResponseWrapper> updateUsers(@RequestBody UserDTO user) {
        UserDTO update = userService.update(user);
        return ResponseEntity.ok(new ResponseWrapper("User update and successfully retrieves",
                HttpStatus.OK));
    }
    @DeleteMapping("/{username}")
    public ResponseEntity<ResponseWrapper> deleteUsers(@PathVariable String username) {
            userService.delete(username);
            return ResponseEntity.ok(new ResponseWrapper("User deleted and successfully retrieves",
                    HttpStatus.OK));
    }


}
