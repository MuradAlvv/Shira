package com.example.projectmanagement.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> getProjectsByUsersId(Long users_id);

    @Query("select COUNT(p) > 0 from Project p join p.users u where p.id =:projectId and u.id = :userId")
    boolean isUserInProject(Long userId, Integer projectId);
}
