package com.example.projectmanagement.project;

import com.example.projectmanagement.security.SecurityUtil;
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

    @GetMapping
    public List<ProjectResponseDto> getUserProjects() {
        return projectService.getProjectsByLoggedUser();
    }

    @PostMapping
    public void create(@RequestBody ProjectRequestDto projectRequestDto) {
        projectService.createProject(projectRequestDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody ProjectRequestDto projectRequestDto) {
        projectService.updateProject(id, projectRequestDto);
    }
}
