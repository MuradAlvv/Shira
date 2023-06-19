package com.example.msnotification.controller;

import com.example.msnotification.model.NotificationRequestDto;
import com.example.msnotification.model.NotificationResponseDto;
import com.example.msnotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody NotificationRequestDto notificationRequestDto) {
        notificationService.createNotification(notificationRequestDto);
    }

    @GetMapping("/user/{userId}")
    public List<NotificationResponseDto> getAllByUserId(@PathVariable Long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }
}
