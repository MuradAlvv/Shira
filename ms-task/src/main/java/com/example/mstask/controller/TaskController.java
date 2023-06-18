package com.example.mstask.controller;

import com.example.mstask.model.TaskRequestDto;
import com.example.mstask.model.TaskResponseDto;
import com.example.mstask.service.TaskService;
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
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public void create(@RequestBody TaskRequestDto taskRequestDto) {
        taskService.createTask(taskRequestDto);
    }

    @PutMapping("/{id}")
    public void changeStatus(@PathVariable Integer id) {
        taskService.changeTaskStatus(id);
    }

    @GetMapping("/project/{projectId}")
    public List<TaskResponseDto> getAllByProjectId(@PathVariable Integer projectId) {
        return taskService.getTasksByProjectId(projectId);
    }
}
