package com.example.msproject.utils;

import com.example.msproject.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SecurityUtil {

    private final UserClient userClient;

    public Long getLoggedUserId(String sessionId) {
        var response = userClient.verify(sessionId);
        return response.getId();
    }
}
