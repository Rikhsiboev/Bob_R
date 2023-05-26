package com.bob_r.controller;

import com.bob_r.client.UserClient;
import com.bob_r.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;

    public Consume_FeignClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping ("/ape/v1/users")
    public ResponseEntity<ResponseWrapper> getUser(){
        return ResponseEntity.ok(new ResponseWrapper("UserList Retrieved",userClient.getUser()));
    };
}
