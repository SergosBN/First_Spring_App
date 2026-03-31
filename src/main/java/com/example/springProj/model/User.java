package com.example.springProj.model;

import jakarta.persistence.*;   // Entity, Table, Id, GenerateValue, GenerationType;

@Entity
@Table(name = "users")
public class User {                      // just information

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // auto_increment
    private Long id;

    private String name;
    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("Name cannot be empty!");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException("Email cannot be empty!");
        } else if (!email.contains("@")) {
            throw new RuntimeException("Invalid email!");
        }
        this.email = email;
    }
}
