package com.example.gateway.service;

import com.example.gateway.client.TaskClient;
import com.example.gateway.client.UserClient;
import com.example.gateway.model.task.TaskRequestDto;
import com.example.gateway.model.task.TaskResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskClient taskClient;
    private final UserClient userClient;

    public void createTask(TaskRequestDto taskRequestDto, String sessionId) {
        var response = userClient.verify(sessionId);
        taskRequestDto.setAuthorId(response.getId());
        taskClient.create(taskRequestDto);
    }

    public List<TaskResponseDto> getAllByProjectId(Integer projectId, String sessionId) {
        userClient.verify(sessionId);
        return taskClient.getAllTasksByProjectId(projectId);
    }
}
