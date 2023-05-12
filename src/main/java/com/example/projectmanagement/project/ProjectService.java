package com.example.projectmanagement.project;

import com.example.projectmanagement.exception.ForbiddenActionException;
import com.example.projectmanagement.security.SecurityUtil;
import com.example.projectmanagement.user.User;
import com.example.projectmanagement.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final SecurityUtil securityUtil;
    private final UserRepository userRepository;

    public List<ProjectResponseDto> getProjectsByLoggedUser() {
        User user = securityUtil.getLoggedUser();
        List<Project> projects = projectRepository.getProjectsByUsersId(user.getId());
        return projectMapper.toResponseDtoList(projects);
    }

    public void createProjectByLoggedUser(ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.toEntity(projectRequestDto);
        User user = securityUtil.getLoggedUser();
        if (Objects.isNull(project.getUsers())) {
            project.setUsers(new HashSet<>());
        }
        project.getUsers().add(user);
        projectRepository.save(project);
    }

    public void updateProject(Integer projectId, ProjectRequestDto projectRequestDto) {
        checkIfLoggedUserInProject(projectId);
        User user = securityUtil.getLoggedUser();
        Project project = projectRepository.findById(projectId).orElseThrow();
        project.setName(projectRequestDto.getName());
        project.setDescription(projectRequestDto.getDescription());
        if (Objects.nonNull(projectRequestDto.getUserEmails())) {
            Set<String> emails = projectRequestDto.getUserEmails();
            Set<User> users = emails.stream().
                    map(email -> userRepository.findUserByEmail(email).orElseThrow()).collect(Collectors.toSet());
            project.setUsers(users);
        }
        if (Objects.isNull(project.getUsers())) {
            project.setUsers(new HashSet<>());
        }
        project.getUsers().add(user);
        projectRepository.save(project);

    }

    public ProjectResponseDto getProjectById(Integer id) {
        checkIfLoggedUserInProject(id);
        Project project = projectRepository.findById(id).orElseThrow();
        return projectMapper.toResponseDto(project);
    }

    private void checkIfLoggedUserInProject(Integer projectId) {
        if (!projectRepository.isUserInProject(securityUtil.getLoggedUserId(), projectId)) {
            throw new ForbiddenActionException();
        }
    }
}
