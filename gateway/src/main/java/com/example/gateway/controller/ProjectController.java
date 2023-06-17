package com.example.gateway.controller;

import com.example.gateway.model.project.ProjectRequestDto;
import com.example.gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public void create(@RequestBody ProjectRequestDto projectRequestDto, HttpServletRequest httpServletRequest) {
        projectService.createProject(projectRequestDto, httpServletRequest);
    }
}
