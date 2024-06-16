package com.example.spring_api.mappers;

import com.example.spring_api.DTO.UserDTO;
import com.example.spring_api.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDto(UserModel user) {
        if (user == null) {
            throw new RuntimeException("User object was null");
        }

        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .ssn(user.getSsn())
                .email(user.getEmail())
                .build();
    }

    public UserDTO toIdDto(UserModel user) {
        if (user == null) {
            throw new RuntimeException("User object was null");
        }

        return UserDTO.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .ssn(user.getSsn())
                .email(user.getEmail())
                .build();
    }

    public UserModel toUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new RuntimeException("UserDTO was null");
        }

        UserModel user = new UserModel();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName (userDTO.getLastName());
        user.setSsn(userDTO.getSsn());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserModel toIdUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new RuntimeException("UserDTO was null");
        }

        UserModel user = new UserModel();
        user.setUserId(userDTO.getUserId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName (userDTO.getLastName());
        user.setSsn(userDTO.getSsn());
        user.setEmail(userDTO.getEmail());
        return user;
    }

}
