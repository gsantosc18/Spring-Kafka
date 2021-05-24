package com.example.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics={"${topic.name}"}, groupId = "user")
    public void listener(ConsumerRecord<String, User> consumerRecord) {
        logger.info(String.format("Consumed message -> %s", consumerRecord.value()));
    }
}
