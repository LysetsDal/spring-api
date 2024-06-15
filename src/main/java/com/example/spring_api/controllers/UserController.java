package com.example.spring_api.controllers;

import com.example.spring_api.exceptions.UserNotFoundException;
import com.example.spring_api.models.UserModel;
import com.example.spring_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<UserModel> handleGetUserById(@PathVariable Integer id) throws UserNotFoundException  {
        return userService.findUserById(id);
    }

}
