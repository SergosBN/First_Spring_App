package com.example.springProj.exception;

public class UserNotFoundException extends RuntimeException {                 // 1. EXCEPTION
    public UserNotFoundException(String message) {
        super(message);
    }
}
