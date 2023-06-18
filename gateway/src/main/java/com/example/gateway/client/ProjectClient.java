package com.example.gateway.client;

import com.example.gateway.config.FeignConfig;
import com.example.gateway.model.project.ProjectRequestDto;
import com.example.gateway.model.project.ProjectResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "ms-project", url = "${client.ms-project.url}", configuration = FeignConfig.class)
public interface ProjectClient {

    @PostMapping("api/projects")
    void create(ProjectRequestDto projectRequestDto);

    @GetMapping("api/projects/user/{userId}")
    List<ProjectResponseDto> getAllByUserId(@PathVariable Long userId);

    @GetMapping("api/projects/{id}")
    ProjectResponseDto getById(@PathVariable Integer id, @CookieValue("JSESSIONID") String sessionId);

}
