package com.example.msproject.repository;

import com.example.msproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("select COUNT(p) > 0 from Project p join p.userIds u where p.id =:projectId and u = :userId")
    boolean isUserInProject(Long userId, Integer projectId);

    @Query("select p from Project p join p.userIds u where u = :userId")
    List<Project> getProjectsByUserId(Long userId);
}
