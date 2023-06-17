package com.example.gateway.service;

import com.example.gateway.client.UserClient;
import com.example.gateway.model.user.UserRequestDto;
import com.example.gateway.model.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserClient userClient;

    public void register(UserRequestDto userRequestDto) {
        userClient.register(userRequestDto);
    }

    public UserResponseDto login(UserRequestDto userRequestDto, HttpServletResponse response) {
        var userResponseDto = userClient.login(userRequestDto);
        Cookie session = new Cookie("JSESSIONID", userResponseDto.getSessionId());
        session.setPath("/");
        session.setMaxAge(4000);
        response.addCookie(session);
        return userResponseDto;
    }
}
