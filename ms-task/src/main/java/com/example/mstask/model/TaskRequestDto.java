package com.example.mstask.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDto {
    private Long authorId;
    private Integer projectId;
    private String title;
    private String description;
    private Long assignedUserId;
}
