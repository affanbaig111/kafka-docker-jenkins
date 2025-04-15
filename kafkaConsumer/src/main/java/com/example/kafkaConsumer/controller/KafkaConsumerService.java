package com.example.kafkaConsumer.controller;
import com.example.kafkaConsumer.dto.User;
import com.example.kafkaConsumer.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final UserRepository userRepository;

    public KafkaConsumerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "user-topic", groupId = "json-group")
    public void consume(User userDto) {
        logger.info("Received user from Kafka: {}", userDto);

        com.example.kafkaConsumer.model.User userEntity = new com.example.kafkaConsumer.model.User();
        userEntity.setName(userDto.getName());
        userEntity.setAge(userDto.getAge());

        userRepository.save(userEntity);
        logger.info("User saved to database: {}", userEntity);
    }
}
