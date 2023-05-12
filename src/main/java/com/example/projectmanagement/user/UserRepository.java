package com.example.projectmanagement.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    @Query("select new com.example.projectmanagement.user.UserResponseDto(u.email) from User u where u.email like :email%")
    List<UserResponseDto> filterUsersByEmail(String email);
}
