package com.example.msproject.mapper;

import com.example.msproject.model.ProjectRequestDto;
import com.example.msproject.model.ProjectResponseDto;
import com.example.msproject.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

//    private final SecurityUtil securityUtil;
//    private final UserRepository userRepository;

    public ProjectResponseDto toResponseDto(Project project) {
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(project.getId());
        projectResponseDto.setName(project.getName());
        projectResponseDto.setDescription(project.getDescription());
        return projectResponseDto;
    }

    public Project toEntity(ProjectRequestDto projectRequestDto) {
        Project project = new Project();
        project.setName(projectRequestDto.getName());
        project.setAuthorId(projectRequestDto.getAuthorId());
        project.setDescription(projectRequestDto.getDescription());
        project.setUserIds(projectRequestDto.getUserIds());
        if (Objects.isNull(project.getUserIds())) {
            project.setUserIds(new HashSet<>());
        }
        project.getUserIds().add(projectRequestDto.getAuthorId());
        return project;
    }

    public List<ProjectResponseDto> toResponseDtoList(List<Project> projects) {
        return projects.stream().map(this::toResponseDto).collect(Collectors.toList());
    }
}
