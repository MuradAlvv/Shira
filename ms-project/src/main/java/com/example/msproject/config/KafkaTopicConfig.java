package com.example.msproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic notificationTopic() {
        return TopicBuilder.name(KafkaTopics.NOTIFICATION_TOPIC).build();
    }

}
