package com.example.spring_api.models;

import jakarta.persistence.*;


@Entity(name = "User")
@Table(name = "user_model")
public class UserModel {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "user_id"
    )
    private Long userId;


    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;


    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;


    @Column(
            name = "ssn",
            nullable = false,
            unique = true
    )
    private String ssn;


    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String email;

    public UserModel() {

    }

    public UserModel(String firstName, String lastName, String ssn, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "UserId=" + userId +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                ", Ssn='" + ssn + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
