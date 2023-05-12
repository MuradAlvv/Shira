package com.example.projectmanagement.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserResponseDto> filterUsersByEmail(String email) {
        return userRepository.filterUsersByEmail(email);
    }
}
