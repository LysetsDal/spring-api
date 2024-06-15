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
    private Long UserId;


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
            nullable = false,
            unique = true
    )
    private String Ssn;


    @Column(
            name = "email",
            nullable = false,
            unique = true
    )
    private String Email;

    public UserModel() {

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
