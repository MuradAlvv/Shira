package com.example.projectmanagement.task;

import lombok.Data;

import java.io.File;

@Data
public class TaskRequestDto {
    private Integer projectId;
    private String title;
    private String description;
    private File attachment;
}
