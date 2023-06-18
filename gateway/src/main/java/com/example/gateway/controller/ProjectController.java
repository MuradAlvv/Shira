package com.example.gateway.controller;

import com.example.gateway.model.project.ProjectRequestDto;
import com.example.gateway.model.project.ProjectResponseDto;
import com.example.gateway.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProjectRequestDto projectRequestDto,
                       @CookieValue("JSESSIONID") String sessionId) {
        projectService.createProject(projectRequestDto, sessionId);
    }

    @GetMapping("/user/{userId}")
    public List<ProjectResponseDto> getAllByUserId(@PathVariable Long userId,
                                                   @CookieValue("JSESSIONID") String sessionId) {
        return projectService.getProjectsByUserId(userId, sessionId);
    }

    @GetMapping("/{id}")
    public ProjectResponseDto getById(@PathVariable Integer id,
                                      @CookieValue("JSESSIONID") String sessionId) {
        return projectService.getById(id, sessionId);
    }
}
