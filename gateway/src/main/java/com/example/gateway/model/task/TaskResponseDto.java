package com.example.gateway.model.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private String title;
    private String description;
    private Integer projectId;
    private Long assignedUserId;
    private Long authorId;
}
