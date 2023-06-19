package com.example.msproject.client;

import com.example.msproject.config.FeignClientConfig;
import com.example.msproject.model.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-auth", url = "${client.ms-auth.url}",
        configuration = FeignClientConfig.class)
public interface UserClient {

    @GetMapping("api/users/profile")
    UserResponseDto verify(@CookieValue("JSESSIONID") String sessionID);
}
