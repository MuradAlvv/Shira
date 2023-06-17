package com.example.gateway.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private String email;
    private Long id;
    private String sessionId;
}
