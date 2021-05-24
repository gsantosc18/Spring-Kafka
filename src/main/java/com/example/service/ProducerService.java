package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        logger.info(String.format("Produced user -> %s", user.getName()));
        this.kafkaTemplate.send(topicName, user.getName(), user);
    }
}
