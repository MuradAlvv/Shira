package com.example.msproject.model;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectRequestDto {
    private Long authorId;
    private String name;
    private String description;
    private Set<Long> userIds;
}
