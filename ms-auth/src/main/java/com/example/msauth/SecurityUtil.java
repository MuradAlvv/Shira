package com.example.msauth;

import com.example.msauth.config.CustomUserDetails;
import com.example.msauth.entity.User;
import com.example.msauth.exception.NotFoundException;
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
        return userRepository.findUserByEmail(customUserDetails.getUsername()).
                orElseThrow(() -> new NotFoundException("user"));
    }

    private CustomUserDetails getUserDetails() {
        var customUserDetails = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if (customUserDetails instanceof CustomUserDetails) {
            return (CustomUserDetails) customUserDetails;
        } else {
            throw new NotFoundException(" credentials ");
        }
    }

    public Long getLoggedUserId() {
        CustomUserDetails customUserDetails = getUserDetails();
        return customUserDetails.getId();
    }
}
