package com.example.gateway.service;

import com.example.gateway.config.KafkaTopics;
import com.example.gateway.model.NotificationResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListeners {

    private final ObjectMapper objectMapper;
    private final NotificationEventPublisher notificationEventPublisher;

    @SneakyThrows
    @KafkaListener(topics = KafkaTopics.NOTIFICATION_UPDATES, groupId = "notification-updates")
    public void listenNotificationUpdates(String data) {
        NotificationResponseDto responseDto = objectMapper.readValue(data, NotificationResponseDto.class);
        notificationEventPublisher.publishNotification(responseDto);
    }
}
