package com.invext.requestdistribution.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static org.apache.kafka.common.config.TopicConfig.RETENTION_MS_CONFIG;

@Configuration
public class KafkaTopicConfiguration {

    private static final int NUM_REPLICAS = 1;
    private static final long RETENTION_POLICY = 604800000L;


    @Bean
    public NewTopic cardSupportTopic() {
        return TopicBuilder
                .name("card-support")
                .replicas(NUM_REPLICAS)
                .config(RETENTION_MS_CONFIG, Long.toString(RETENTION_POLICY))
                .compact()
                .build();
    }

    @Bean
    public NewTopic loanSupportTopic() {
        return TopicBuilder
                .name("loan-support")
                .replicas(NUM_REPLICAS)
                .config(RETENTION_MS_CONFIG, Long.toString(RETENTION_POLICY))
                .compact()
                .build();
    }

    @Bean
    public NewTopic otherSupportTopic() {
        return TopicBuilder
                .name("other-support")
                .replicas(NUM_REPLICAS)
                .config(RETENTION_MS_CONFIG, Long.toString(RETENTION_POLICY))
                .compact()
                .build();
    }
}
