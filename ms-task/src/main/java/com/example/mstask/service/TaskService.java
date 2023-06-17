package com.example.mstask.service;

import com.example.mstask.dto.TaskRequestDto;
import com.example.mstask.entity.Task;
import com.example.mstask.exception.NotFoundException;
import com.example.mstask.repository.TaskRepository;
import com.example.mstask.common.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        task.setAttachment(taskRequestDto.getAttachment());
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
}
