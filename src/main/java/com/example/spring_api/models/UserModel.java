package com.example.spring_api.models;

import jakarta.persistence.*;


@Entity(name = "User")
@Table(name = "user_model")
public class UserModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "user_id"
    )
    private Integer UserId;


    @Column(
            name = "first_name",
            nullable = false
    )
    private String FirstName;


    @Column(
            name = "last_name",
            nullable = false
    )
    private String LastName;


    @Column(
            name = "ssn",
            unique = true
    )
    private String Ssn;


    @Column(
            name = "email",
            unique = true
    )
    private String Email;

    public UserModel(String firstName, String lastName, String ssn, String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Ssn = ssn;
        this.Email = email;
    }

    public UserModel(Integer userId, String firstName, String lastName, String ssn, String email) {
        this.UserId = userId;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Ssn = ssn;
        this.Email = email;
    }

    public UserModel() {

    }

    public Integer getUserId() {
        return UserId;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getSsn() {
        return Ssn;
    }

    public void setSsn(String ssn) {
        this.Ssn = ssn;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Ssn='" + Ssn + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
