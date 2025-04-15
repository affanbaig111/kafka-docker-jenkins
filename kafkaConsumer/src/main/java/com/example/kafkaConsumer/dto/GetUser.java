package com.example.kafkaConsumer.dto;
public class GetUser {
    private Long id;
    private String name;
    private int age;

    // Default constructor
    public GetUser() {
    }

    // All-args constructor (optional)
    public GetUser(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString (optional, helpful for logging/debugging)
    @Override
    public String toString() {
        return "GetUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}