package com.example.mstask.repository;

import com.example.mstask.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> getTasksByProjectId(Integer projectId);
}
