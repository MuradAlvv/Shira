package com.example.projectmanagement.project;

import com.example.projectmanagement.security.SecurityUtil;
import com.example.projectmanagement.user.User;
import com.example.projectmanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

    private final SecurityUtil securityUtil;
    private final UserRepository userRepository;

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
        project.setAuthor(securityUtil.getLoggedUser());
        project.setDescription(projectRequestDto.getDescription());
        if (Objects.nonNull(projectRequestDto.getUserEmails())) {
            List<String> emails = projectRequestDto.getUserEmails();
            List<User> users = emails.stream().
                    map(email -> userRepository.findUserByEmail(email).orElseThrow()).collect(Collectors.toList());
            project.setUsers(users);
        }
        return project;
    }

    public List<ProjectResponseDto> toResponseDtoList(List<Project> projects) {
        return projects.stream().map(this::toResponseDto).collect(Collectors.toList());
    }
}
