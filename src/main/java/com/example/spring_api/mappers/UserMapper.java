package com.example.spring_api.mappers;

import com.example.spring_api.DTO.UserDTO;
import com.example.spring_api.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDto(UserModel user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setSsn(user.getSsn());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public UserModel toUser(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(userDTO.getFirstName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setSsn(userDTO.getSsn());
        userModel.setEmail(userDTO.getEmail());
        return userModel;
    }
}
