package com.bob.kafka.congfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean  // we are creating topic
    public NewTopic topicBob(){
        return TopicBuilder
                .name("topicNameBob")
//                .partitions(5)
//                .replicas(2)
                .build();
    }
}
