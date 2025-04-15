package com.example.kafkaSender.service;

import com.example.kafkaSender.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "user-topic";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(User user) {
        kafkaTemplate.send(TOPIC, user);
    }
}