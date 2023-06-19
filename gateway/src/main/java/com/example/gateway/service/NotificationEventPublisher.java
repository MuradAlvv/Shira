package com.example.gateway.service;

import com.example.gateway.model.NotificationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationEventPublisher {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void publishNotification(NotificationResponseDto notificationResponseDto) {
        simpMessagingTemplate.convertAndSend("/topic/notifications", notificationResponseDto);
        //TODO:send to specific user
    }
}
