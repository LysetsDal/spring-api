package com.example.spring_api.controllers;

import com.example.spring_api.DTO.UserDTO;
import com.example.spring_api.exceptions.UserNotFoundException;
import com.example.spring_api.mappers.UserMapper;
import com.example.spring_api.models.UserModel;
import com.example.spring_api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users/list")
    public ResponseEntity<List<UserDTO>> handleGetAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<UserDTO> handleGetUserById(@PathVariable Integer id) throws UserNotFoundException  {
        return userService.findUserById(id);
    }

    @GetMapping("/users/first-name")
    public ResponseEntity<List<UserDTO>> handleGetUsersByFirstName(@RequestParam(value = "name") String name) throws UserNotFoundException  {
        return userService.findUsersByFirstName(name);
    }

    @GetMapping("/users/last-name")
    public ResponseEntity<List<UserDTO>> handleGetUsersByLastName(@RequestParam(value = "name") String name) throws UserNotFoundException  {
        return userService.findUsersByLastName(name);
    }

    @PostMapping("/users/create")
    public ResponseEntity<UserDTO> handleCreateUser(@RequestBody UserDTO userDTO) {
        UserModel createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(userMapper.toDto(createdUser));
    }

}
