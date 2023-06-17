package com.example.msauth.service;

import com.example.msauth.SecurityUtil;
import com.example.msauth.model.UserRequestDto;
import com.example.msauth.entity.User;
import com.example.msauth.repository.UserRepository;
import com.example.msauth.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final SecurityUtil securityUtil;

    public void register(UserRequestDto userRequestDto) {
        User user = new User();
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userRepository.save(user);
        //TODO: add email validation
    }

    public UserResponseDto login(UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userRepository.findUserByEmail(userRequestDto.getEmail()).orElseThrow();

        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        var response = new UserResponseDto();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setSessionId(sessionID);
        return response;
    }

    public UserResponseDto getUserProfile() {
        User user = securityUtil.getLoggedUser();
        var response = new UserResponseDto();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        return response;
    }

    public List<UserResponseDto> filterUsersByEmail(String email) {
        return userRepository.filterUsersByEmail(email);
    }
}
