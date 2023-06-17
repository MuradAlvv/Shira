package com.example.msproject.service;

import com.example.msproject.entity.Project;
import com.example.msproject.mapper.ProjectMapper;
import com.example.msproject.repository.ProjectRepository;
import com.example.msproject.model.ProjectRequestDto;
import com.example.msproject.model.ProjectResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectResponseDto> getProjectsByUserId(Long userId) {
        List<Project> projects = projectRepository.getProjectsByUserId(userId);
        return projectMapper.toResponseDtoList(projects);
    }

    public void createProject(ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.toEntity(projectRequestDto);
        projectRepository.save(project);
    }

//    public void updateProject(Integer projectId, ProjectRequestDto projectRequestDto) {
//        checkIfLoggedUserInProject(projectId);
//        User user = securityUtil.getLoggedUser();
//        Project project = projectRepository.findById(projectId).orElseThrow();
//        project.setName(projectRequestDto.getName());
//        project.setDescription(projectRequestDto.getDescription());
//        if (Objects.nonNull(projectRequestDto.getUserEmails())) {
//            Set<String> emails = projectRequestDto.getUserEmails();
//            Set<User> users = emails.stream().
//                    map(email -> userRepository.findUserByEmail(email).
//                            orElseThrow(() -> new NotFoundException("project"))).
//                    collect(Collectors.toSet());
//            project.setUsers(users);
//        }
//        if (Objects.isNull(project.getUsers())) {
//            project.setUsers(new HashSet<>());
//        }
//        project.getUsers().add(user);
//        projectRepository.save(project);
//    }
//
//    public ProjectResponseDto getProjectById(Integer id) {
//        checkIfLoggedUserInProject(id);
//        Project project = projectRepository.findById(id).orElseThrow(() -> new NotFoundException("project"));
//        return projectMapper.toResponseDto(project);
//    }

//    private void checkIfLoggedUserInProject(Integer projectId) {
//        if (!projectRepository.isUserInProject(securityUtil.getLoggedUserId(), projectId)) {
//            throw new ForbiddenActionException();
//        }
//    }

    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.toResponseDtoList(projectRepository.findAll());
    }
}
