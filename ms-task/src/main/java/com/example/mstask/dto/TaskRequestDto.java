package com.example.mstask.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
public class TaskRequestDto {
    private Long authorId;
    private Long projectId;
    private String title;
    private String description;
    private File attachment;
}
