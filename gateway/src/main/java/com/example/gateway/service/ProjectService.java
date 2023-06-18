package com.example.gateway.service;

import com.example.gateway.client.ProjectClient;
import com.example.gateway.client.UserClient;
import com.example.gateway.exception.ForbiddenActionException;
import com.example.gateway.model.project.ProjectRequestDto;
import com.example.gateway.model.project.ProjectResponseDto;
import com.example.gateway.model.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final UserClient userClient;
    private final ProjectClient projectClient;

    public void createProject(ProjectRequestDto projectRequestDto, String sessionId) {
        UserResponseDto responseDto = userClient.verify(sessionId);
        projectRequestDto.setAuthorId(responseDto.getId());
        projectClient.create(projectRequestDto);
    }

    public List<ProjectResponseDto> getProjectsByUserId(Long userId, String sessionId) {
        UserResponseDto responseDto = userClient.verify(sessionId);
        if (responseDto.getId().equals(userId)) {
            return projectClient.getAllByUserId(userId);
        }
        throw new ForbiddenActionException();
    }

    public ProjectResponseDto getById(Integer id, String sessionId) {
        userClient.verify(sessionId);
        return projectClient.getById(id, sessionId);
    }
}
