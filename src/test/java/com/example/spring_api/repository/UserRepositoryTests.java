package com.example.spring_api.repository;

import com.example.spring_api.models.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;



    @Test
    public void UserRepository_SaveAll_ReturnSavedUsers() {
        // Arrange
        UserModel user = new UserModel(
                "Alice",
                "Andersen",
                "112233-1234",
                "alice.andersen@gmail.com");

        // Act
        UserModel savedUser = userRepository.save(user);

        // Assert
        Assertions.assertNotNull(savedUser);
        Assertions.assertTrue(savedUser.getUserId() > 0);
    }

    @Test
    public void UserRepository_DeleteUserById_ReturnsUserId() {
        // Arrange
        UserModel user = new UserModel(
                "Alice",
                "Andersen",
                "112233-1234",
                "alice.andersen@gmail.com");

        userRepository.save(user);

        // Act
        List<UserModel> fetchedUser = userRepository.findUserByFirstName("Alice");
        Long fetchedUserId = fetchedUser.get(0).getUserId();
        userRepository.deleteById(fetchedUserId.intValue());

        // Assert
        Optional<UserModel> deletedUser = userRepository.findById(fetchedUserId.intValue());
        Assertions.assertFalse(deletedUser.isPresent());
    }
}
