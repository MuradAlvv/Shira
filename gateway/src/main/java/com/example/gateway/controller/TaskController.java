package com.example.gateway.controller;

import com.example.gateway.model.task.TaskRequestDto;
import com.example.gateway.model.task.TaskResponseDto;
import com.example.gateway.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TaskRequestDto taskRequestDto, @CookieValue("JSESSIONID") String sessionId) {
        taskService.createTask(taskRequestDto, sessionId);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponseDto> getAllByProjectId(@PathVariable Integer projectId,
                                                   @CookieValue("JSESSIONID") String sessionId) {
        return taskService.getAllByProjectId(projectId, sessionId);
    }
}
