package com.example.gateway.client;

import com.example.gateway.config.FeignConfig;
import com.example.gateway.model.project.ProjectRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ms-project", url = "http://localhost:8082/",configuration = FeignConfig.class)
public interface ProjectClient {

    @PostMapping("api/projects")
    void create(ProjectRequestDto projectRequestDto);

}
