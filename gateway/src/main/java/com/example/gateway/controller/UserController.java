package com.example.gateway.controller;

import com.example.gateway.model.user.UserRequestDto;
import com.example.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        userService.register(userRequestDto);
    }

    @PostMapping("/auth/login")
    public void login(@RequestBody UserRequestDto userRequestDto, HttpServletResponse response) {
        userService.login(userRequestDto, response);
    }
}
