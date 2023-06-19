package com.example.msproject.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class NotificationRequestDto {
    private String title;
    private String content;
    private Set<Long> usersIds;
}
