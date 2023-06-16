package com.example.projectmanagement.task;

import com.example.projectmanagement.exception.NotFoundException;
import com.example.projectmanagement.project.ProjectRepository;
import com.example.projectmanagement.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final SecurityUtil securityUtil;
    private final ProjectRepository projectRepository;

    public void createTaskByLoggedUser(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setAuthor(securityUtil.getLoggedUser());
        task.setStatus(TaskStatus.TO_DO);
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setAttachment(taskRequestDto.getAttachment());
        task.setProject(projectRepository.findById(taskRequestDto.getProjectId()).orElseThrow());
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
