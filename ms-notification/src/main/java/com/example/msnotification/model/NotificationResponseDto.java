package com.example.msnotification.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
