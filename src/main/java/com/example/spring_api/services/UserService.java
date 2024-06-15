package com.example.spring_api.services;

import com.example.spring_api.exceptions.UserNotFoundException;
import com.example.spring_api.models.UserModel;
import com.example.spring_api.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserModel> findUserById(Integer id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("No user found with id: " + id);
        }
        return ResponseEntity.ok(user.get());
    }
}
