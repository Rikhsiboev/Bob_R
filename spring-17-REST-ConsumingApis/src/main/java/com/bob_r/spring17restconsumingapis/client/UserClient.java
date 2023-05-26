package com.bob_r.spring17restconsumingapis.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://jsonplaceholder.typicode.com/users",name = "User-CLIENT")
public interface UserClient {
}
