package com.example.msnotification.service;

import com.example.msnotification.config.KafkaTopics;
import com.example.msnotification.model.NotificationRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaListeners {

    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    @KafkaListener(topics = KafkaTopics.NOTIFICATION_TOPIC, groupId = "notifications")
    public void listenNotificationTopic(String data) {
        NotificationRequestDto requestDto = objectMapper.readValue(data, NotificationRequestDto.class);
        notificationService.createNotification(requestDto);
    }
}
