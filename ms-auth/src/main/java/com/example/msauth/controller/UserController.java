package com.example.msauth.controller;

import com.example.msauth.model.SessionResponseDto;
import com.example.msauth.model.UserRequestDto;
import com.example.msauth.model.UserResponseDto;
import com.example.msauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserRequestDto userRequestDto) {
        userService.register(userRequestDto);
    }

    @PostMapping("/login")
    public SessionResponseDto login(@RequestBody UserRequestDto userRequestDto) {
        return userService.login(userRequestDto);
    }

    @GetMapping("/profile")
    public UserResponseDto getLoggedUserProfile() {
        return userService.getUserProfile();
    }

    @GetMapping
    public List<UserResponseDto> getUsersByEmailFilter(@RequestParam String email) {
        return userService.filterUsersByEmail(email);
    }
}
