package com.example.gateway.client;

import com.example.gateway.config.FeignConfig;
import com.example.gateway.model.SessionResponseDto;
import com.example.gateway.model.user.UserRequestDto;
import com.example.gateway.model.user.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ms-auth", url = "${client.ms-auth.url}", configuration = FeignConfig.class)
public interface UserClient {

    @PostMapping("/api/users/register")
    void register(UserRequestDto userRequestDto);

    @PostMapping("api/users/login")
    SessionResponseDto login(UserRequestDto userRequestDto);

    @GetMapping("api/users/profile")
    UserResponseDto verify(@CookieValue("JSESSIONID") String sessionID);

}
