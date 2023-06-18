package com.example.gateway.service;

import com.example.gateway.client.UserClient;
import com.example.gateway.model.user.UserRequestDto;
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

    public void login(UserRequestDto userRequestDto, HttpServletResponse response) {
        var sessionResponseDto = userClient.login(userRequestDto);
        Cookie session = new Cookie("JSESSIONID", sessionResponseDto.getSessionId());
        session.setPath("/");
        session.setMaxAge(3600);
        response.addCookie(session);
    }
}
