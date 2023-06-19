package com.example.msnotification.repository;

import com.example.msnotification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("select n from Notification n inner join n.usersIds u where u = :userId")
    List<Notification> getNotificationsByUserId(Long userId);
}
