package com.example.gateway.client;

import com.example.gateway.config.FeignConfig;
import com.example.gateway.model.user.UserRequestDto;
import com.example.gateway.model.user.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ms-auth", url = "${client.ms-user.url}", configuration = FeignConfig.class)
public interface UserClient {

    @PostMapping("/api/users/register")
    void register(UserRequestDto userRequestDto);

    @PostMapping("api/users/login")
    UserResponseDto login(UserRequestDto userRequestDto);

    @GetMapping("api/users/profile")
    UserResponseDto verify(@RequestHeader("Cookie") String sessionID);

}
