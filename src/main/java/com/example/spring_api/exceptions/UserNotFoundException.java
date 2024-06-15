package com.example.spring_api.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String err) {
        super(err);
    }
}