package com.example.msnotification.service;

import com.example.msnotification.config.KafkaTopics;
import com.example.msnotification.entity.Notification;
import com.example.msnotification.model.NotificationRequestDto;
import com.example.msnotification.model.NotificationResponseDto;
import com.example.msnotification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final KafkaTemplate<String, NotificationResponseDto> kafkaTemplate;

    public void createNotification(NotificationRequestDto notificationRequestDto) {
        Notification notification = new Notification();
        notification.setContent(notificationRequestDto.getContent());
        notification.setTitle(notificationRequestDto.getTitle());
        notification.setUsersIds(notificationRequestDto.getUsersIds());
        notificationRepository.save(notification);

        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        notificationResponseDto.setCreatedAt(notification.getCreatedAt());
        notificationResponseDto.setTitle(notification.getTitle());
        notificationResponseDto.setContent(notification.getContent());
        kafkaTemplate.send(KafkaTopics.NOTIFICATION_UPDATES, notificationResponseDto);
    }

    public List<NotificationResponseDto> getNotificationsByUserId(Long userId) {
        List<Notification> notifications = notificationRepository.getNotificationsByUserId(userId);
        return notifications.stream().map(notification -> {
            var dto = new NotificationResponseDto();
            dto.setContent(notification.getContent());
            dto.setTitle(notification.getTitle());
            dto.setCreatedAt(notification.getCreatedAt());
            return dto;
        }).collect(Collectors.toList());
    }
}
