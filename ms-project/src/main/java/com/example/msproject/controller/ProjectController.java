package com.example.msproject.controller;

import com.example.msproject.dto.ProjectRequestDto;
import com.example.msproject.dto.ProjectResponseDto;
import com.example.msproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public List<ProjectResponseDto> getAllProjects() {
        return projectService.getAllProjects();
    }

//    @GetMapping
//    public List<ProjectResponseDto> getUserProjects() {
//        return projectService.getProjectsByLoggedUser();
//    }
//
//    @GetMapping("/{id}")
//    public ProjectResponseDto getProjectById(@PathVariable Integer id) {
//        return projectService.getProjectById(id);
//    }
//
//    @PostMapping
//    public void create(@RequestBody ProjectRequestDto projectRequestDto) {
//        projectService.createProjectByLoggedUser(projectRequestDto);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable Integer id, @RequestBody ProjectRequestDto projectRequestDto) {
//        projectService.updateProject(id, projectRequestDto);
//    }
}
