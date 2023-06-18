package com.example.msnotification.service;

import com.example.msnotification.entity.Notification;
import com.example.msnotification.model.NotificationRequestDto;
import com.example.msnotification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNotification(NotificationRequestDto notificationRequestDto) {
        Notification notification = new Notification();
        notification.setContent(notificationRequestDto.getContent());
        notification.setTitle(notificationRequestDto.getTitle());
        notification.setUsersIds(notificationRequestDto.getUsersIds());
        notificationRepository.save(notification);
    }
}
