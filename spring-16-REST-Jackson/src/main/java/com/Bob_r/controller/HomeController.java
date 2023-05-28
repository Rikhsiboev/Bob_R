package com.Bob_r.controller;

import com.Bob_r.dto.AccountDTO;
import com.Bob_r.dto.UserDTO;
import com.Bob_r.service.AccountService;
import com.Bob_r.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;
    private final AccountService accountService;

    public HomeController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<UserDTO> readAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/accounts")
    public List<AccountDTO> readAllAccounts() {
        return accountService.getAccounts();
    }

}
