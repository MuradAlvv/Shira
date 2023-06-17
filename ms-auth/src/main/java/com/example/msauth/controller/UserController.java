package com.example.msauth.controller;

import com.example.msauth.dto.UserResponseDto;
import com.example.msauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getUsersByEmailFilter(@RequestParam String email) {
        return userService.filterUsersByEmail(email);
    }
}
