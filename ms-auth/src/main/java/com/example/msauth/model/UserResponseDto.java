package com.example.msauth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long id;
    private String email;
    private String sessionId;

    public UserResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
