package com.example.msauth.controller;

import com.example.msauth.dto.UserRequestDto;
import com.example.msauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRequestDto userRequestDto) {
        userService.register(userRequestDto);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserRequestDto userRequestDto) {
        userService.login(userRequestDto);
    }
}
