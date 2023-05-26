package com.bob_r.client;

import com.bob_r.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/users", name = "User-CLIENT")
public interface UserClient {
    @GetMapping("/user")
    List<User> getUser();


}
