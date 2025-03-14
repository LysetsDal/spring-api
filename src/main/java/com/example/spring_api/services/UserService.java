package com.example.spring_api.services;

import com.example.spring_api.exceptions.UserNotFoundException;
import com.example.spring_api.mappers.UserMapper;
import com.example.spring_api.models.UserModel;
import com.example.spring_api.repository.UserRepository;
import com.example.spring_api.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserModel> entities = userRepository.findAll();
        if (entities.isEmpty()) {
            throw new UserNotFoundException("No users in the database");
        }

        List<UserDTO> response = entities.stream()
                .map(userMapper::toIdDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<UserDTO> findUserById(Integer id) {
        Optional<UserModel> entity = userRepository.findById(id);
        if (entity.isEmpty()){
            throw new UserNotFoundException("No user found with id: " + id);
        }

        return ResponseEntity.ok(userMapper.toIdDto(entity.get()));
    }

    public ResponseEntity<List<UserDTO>> findUsersByFirstName(String firstName) {
        List<UserModel> entities = userRepository.findUserByFirstName(firstName);
        if (entities.isEmpty()) {
            throw new UserNotFoundException("No user by that first name");
        }

        List<UserDTO> result = entities.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<UserDTO>> findUsersByLastName(String lastName) {
        List<UserModel> entities = userRepository.findUserByLastName(lastName);
        if (entities.isEmpty()) {
            throw new UserNotFoundException("No user by that last name");
        }

        List<UserDTO> result = entities.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    public ResponseEntity<UserDTO>  findUsersBySsn(String ssn) throws UserNotFoundException{
        Optional<UserModel> entity = userRepository.findUserBySsn(ssn);
        if(entity.isEmpty()) { throw new UserNotFoundException("No user with that ssn"); }

        return ResponseEntity.ok(userMapper.toDto(entity.get()));
    }

    public UserModel changeUserEmail(Integer userID, String email) {
        Optional<UserModel> entity = userRepository.findById(userID);
        if (entity.isEmpty()) {
            throw new UserNotFoundException("No user by that id");
        }

        UserModel user = entity.get();
        user.setEmail(email);

        return userRepository.save(user);
    }


    public UserModel createUser(UserDTO userDTO) {
        UserModel entity = userMapper.toIdUser(userDTO);

        return userRepository.save(entity);
    }

    public ResponseEntity<Long> deleteUser(Long userID) {
        Optional<UserModel> entity = userRepository.findById(userID.intValue());

        if (entity.isEmpty()) {
            throw new UserNotFoundException("No user by that id: " + userID);
        }

        userRepository.delete(entity.get());
        return ResponseEntity.ok(entity.get().getUserId());
    }

}


