package com.example.kafkaConsumer.repo;
import com.example.kafkaConsumer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}