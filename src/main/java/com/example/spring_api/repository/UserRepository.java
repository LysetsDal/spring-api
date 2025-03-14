package com.example.spring_api.repository;


import com.example.spring_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findUserByFirstName(String firstName);
    List<UserModel> findUserByLastName(String lastName);
    Optional<UserModel> findUserBySsn(String ssn);
}
