package com.example.spring_api.services;

import com.example.spring_api.exceptions.UserNotFoundException;
import com.example.spring_api.mappers.UserMapper;
import com.example.spring_api.models.UserModel;
import com.example.spring_api.repository.IUserRepository;
import com.example.spring_api.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserModel> entities = userRepository.findAll();
        if (entities.isEmpty()) {
            throw new UserNotFoundException("No users in the database");
        }

        List<UserDTO> response = entities.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserDTO> findUserById(Integer id) {
        Optional<UserModel> entity = userRepository.findById(id);
        if (entity.isEmpty()){
            throw new UserNotFoundException("No user found with id: " + id);
        }

        return ResponseEntity.ok(userMapper.toDto(entity.get()));
    }

    public ResponseEntity<List<UserDTO>> findUsersByFirstName(String firstName) {
        List<UserModel> entities = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();

        for (UserModel user : entities) {
            if (user.getFirstName().equals(firstName)) {
                result.add(userMapper.toDto(user));
            }
        }

        if (result.isEmpty()) {
            throw new UserNotFoundException("No user by that first name");
        }

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<UserDTO>> findUsersByLastName(String lastName) {
        List<UserModel> entities = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();

        for (UserModel user : entities) {
            if (user.getLastName().equals(lastName)) {
                result.add(userMapper.toDto(user));
            }
        }

        if (result.isEmpty()) {
            throw new UserNotFoundException("No user by that last name");
        }

        return ResponseEntity.ok(result);
    }


    public UserModel createUser(UserDTO userDTO) {
        UserModel entity = userMapper.toUser(userDTO);

        return userRepository.save(entity);
    }

}
