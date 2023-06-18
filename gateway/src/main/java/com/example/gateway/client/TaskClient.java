package com.example.gateway.client;

import com.example.gateway.config.FeignConfig;
import com.example.gateway.model.task.TaskRequestDto;
import com.example.gateway.model.task.TaskResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "ms-task", url = "${client.ms-task.url}", configuration = FeignConfig.class)
public interface TaskClient {

    @PostMapping("api/tasks")
    void create(TaskRequestDto taskRequestDto);

    @GetMapping("api/tasks/project/{projectId}")
    List<TaskResponseDto> getAllTasksByProjectId(@PathVariable Integer projectId);
}
