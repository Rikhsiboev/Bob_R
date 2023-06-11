package com.Bob_R.controller.controllerRest;

import com.Bob_R.dto.ResponseWrapper;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.exception.TicketingProjectException;
import com.Bob_R.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name= "UserController", description = "User Api")
public class UserControllerRest {

    private final UserService userService;

    public UserControllerRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RolesAllowed({"Manager","Admin"})
    @Operation(summary = "Get users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        List<UserDTO> userDTOList = userService.listAllUsers();
        return ResponseEntity.ok(
                new ResponseWrapper("Users are successfully retrieves",
                userDTOList, HttpStatus.OK));
    }

    @GetMapping("/{username}")
    @RolesAllowed({"Admin"})
    @Operation(summary = "Get usersBy User Name")
    public ResponseEntity<ResponseWrapper> getUserByUserName(@PathVariable("username") String userName){
        UserDTO user = userService.findByUserName(userName);
        return ResponseEntity.ok(
                new ResponseWrapper("User is successfully retrieved",
                        user,
                        HttpStatus.OK));
    }

    @PostMapping
    @RolesAllowed({"Admin"})
    @Operation(summary = "Create users")
    public ResponseEntity<ResponseWrapper> createUser(@RequestBody UserDTO user){
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseWrapper("User is successfully created",
                HttpStatus.CREATED));
    }

    @PutMapping
    @RolesAllowed({"Admin"})
    @Operation(summary = "Update users")
    public ResponseEntity<ResponseWrapper> updateUser(@RequestBody UserDTO user){
        userService.update(user);
        return ResponseEntity.ok(
                new ResponseWrapper("User is successfully updated",
                        HttpStatus.OK));

    }

    @DeleteMapping("/{username}")
    @RolesAllowed({"Admin"})
    @Operation(summary = "Delete users")
    public ResponseEntity<ResponseWrapper> deleteUser(@PathVariable("username") String userName) throws TicketingProjectException {
        userService.delete(userName);
        return ResponseEntity.ok(
                new ResponseWrapper("User is successfully deleted",
                        HttpStatus.OK));

    }




}
