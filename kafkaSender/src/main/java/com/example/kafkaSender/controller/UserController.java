package com.example.kafkaSender.controller;

import com.example.kafkaSender.model.User;
import com.example.kafkaSender.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public ResponseEntity<String> sendUser(@RequestBody User user) {
        kafkaProducerService.send(user);
        return ResponseEntity.ok("User sent to Kafka");
    }
}
