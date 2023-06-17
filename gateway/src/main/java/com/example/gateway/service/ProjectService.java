package com.example.gateway.service;

import com.example.gateway.client.ProjectClient;
import com.example.gateway.client.UserClient;
import com.example.gateway.model.project.ProjectRequestDto;
import com.example.gateway.model.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final UserClient userClient;
    private final ProjectClient projectClient;

    public void createProject(ProjectRequestDto projectRequestDto, HttpServletRequest httpServletRequest) {
        UserResponseDto responseDto = userClient.verify(httpServletRequest.getHeader("Cookie"));
        projectRequestDto.setAuthorId(responseDto.getId());
        projectClient.create(projectRequestDto);
    }
}
