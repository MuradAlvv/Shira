package com.example.gateway.model.task;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskResponseDto {
    private String title;
    private String description;
    private Integer projectId;
    private Long assignedUserId;
    private Long authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
