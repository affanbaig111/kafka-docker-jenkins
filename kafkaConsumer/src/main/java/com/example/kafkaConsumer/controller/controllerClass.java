package com.example.kafkaConsumer.controller;

import com.example.kafkaConsumer.dto.GetUser;
import com.example.kafkaConsumer.model.User;
import com.example.kafkaConsumer.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class controllerClass {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<GetUser>> getUser() {
        List<User> users = userRepository.findAll();

        List<GetUser> response = users.stream()
                .map(user -> new GetUser(user.getId(), user.getName(), user.getAge()))
                .toList();

        return ResponseEntity.ok(response);
    }
}
