package com.example.kafkaConsumer.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;


    // Default constructor (required for JSON deserialization)
    public User() {
    }

    // All-args constructor (optional, but useful)
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Optional: toString() for logging/debugging
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + '}';
    }
}