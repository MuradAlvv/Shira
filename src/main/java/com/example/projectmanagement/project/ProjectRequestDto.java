package com.example.projectmanagement.project;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectRequestDto {
    private String name;
    private String description;
    private Set<String> userEmails;
}
