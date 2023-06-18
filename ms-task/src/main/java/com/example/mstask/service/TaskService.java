package com.example.mstask.service;

import com.example.mstask.common.TaskStatus;
import com.example.mstask.entity.Task;
import com.example.mstask.exception.NotFoundException;
import com.example.mstask.model.TaskRequestDto;
import com.example.mstask.model.TaskResponseDto;
import com.example.mstask.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void createTask(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setAuthorId(taskRequestDto.getAuthorId());
        task.setStatus(TaskStatus.TO_DO);
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setProjectId(taskRequestDto.getProjectId());
        taskRepository.save(task);
    }

    public void changeTaskStatus(Integer taskId) {
        Task task = taskRepository.findById(taskId).
                orElseThrow(() -> new NotFoundException("task"));
        TaskStatus currentStatus = task.getStatus();
        task.setStatus(currentStatus.getNextStatus());
        taskRepository.save(task);
    }

    public List<TaskResponseDto> getTasksByProjectId(Integer projectId) {
        List<Task> tasks = taskRepository.getTasksByProjectId(projectId);
        if (tasks.isEmpty()) {
            throw new NotFoundException("task");
        }
        return tasks.stream().map(task -> {
            TaskResponseDto dto = new TaskResponseDto();
            dto.setProjectId(task.getProjectId());
            dto.setTitle(task.getTitle());
            dto.setDescription(task.getDescription());
            dto.setAssignedUserId(task.getAssignedUserId());
            dto.setAuthorId(task.getAuthorId());
            return dto;
        }).toList();
    }
}
