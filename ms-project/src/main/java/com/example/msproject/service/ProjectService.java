package com.example.msproject.service;

import com.example.msproject.config.KafkaTopics;
import com.example.msproject.entity.Project;
import com.example.msproject.exception.ForbiddenActionException;
import com.example.msproject.exception.NotFoundException;
import com.example.msproject.mapper.ProjectMapper;
import com.example.msproject.model.NotificationRequestDto;
import com.example.msproject.repository.ProjectRepository;
import com.example.msproject.model.ProjectRequestDto;
import com.example.msproject.model.ProjectResponseDto;
import com.example.msproject.utils.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final SecurityUtil securityUtil;
    private final KafkaTemplate<String, NotificationRequestDto> kafkaTemplate;

    public List<ProjectResponseDto> getProjectsByUserId(Long userId) {
        List<Project> projects = projectRepository.getProjectsByUserId(userId);
        return projectMapper.toResponseDtoList(projects);
    }

    public void createProject(ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.toEntity(projectRequestDto);
        projectRepository.save(project);

        NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
        notificationRequestDto.setContent("You have been added to project " + project.getName());
        notificationRequestDto.setTitle("New project!");
        notificationRequestDto.setUsersIds(project.getUserIds());
        kafkaTemplate.send(KafkaTopics.NOTIFICATION_TOPIC, notificationRequestDto);
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
    public ProjectResponseDto getProjectById(Integer projectId, String sessionId) {
        Long userId = securityUtil.getLoggedUserId(sessionId);
        checkIfUserInProject(projectId, userId);
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NotFoundException("project"));
        return projectMapper.toResponseDto(project);
    }

    private void checkIfUserInProject(Integer projectId, Long userId) {
        if (!projectRepository.isUserInProject(userId, projectId)) {
            throw new ForbiddenActionException();
        }
    }

    public List<ProjectResponseDto> getAllProjects() {
        return projectMapper.toResponseDtoList(projectRepository.findAll());
    }
}
