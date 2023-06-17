package com.example.msauth.config;

import com.example.msauth.entity.User;
import com.example.msauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    private final UserRepository userRepository;

    public User getLoggedUser() {
        CustomUserDetails customUserDetails = getUserDetails();
        return userRepository.findUserByEmail(customUserDetails.getUsername()).orElseThrow();
    }

    private CustomUserDetails getUserDetails() {
        return (CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
    }

    public Long getLoggedUserId() {
        CustomUserDetails customUserDetails = getUserDetails();
        return customUserDetails.getId();
    }
}
