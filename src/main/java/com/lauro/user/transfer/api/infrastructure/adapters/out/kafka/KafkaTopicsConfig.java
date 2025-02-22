package com.lauro.user.transfer.api.infrastructure.adapters.out.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic createTransferTopic() {
        return TopicBuilder.name("transfer-topic")
                .partitions(1)
                .replicas(1)
                .compact()
                .build();
    }
}
