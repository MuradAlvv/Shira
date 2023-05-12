package com.example.projectmanagement.security.auth;

import com.example.projectmanagement.user.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto);
    }

    @PostMapping("/login")
    public void login(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.login(userRequestDto);
    }
}
