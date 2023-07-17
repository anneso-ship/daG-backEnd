package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String firstName;
    private String identifier;
    private String password;
    private String email;
    private String phoneNumber;
    private String role;
    private String requestProcessStatus;

    public User(){}

    public User(String name, String firstName,
                String identifier, String password,
                String email, String phoneNumber,
                String role, String requestProcessStatus) {
        this.name = name;
        this.firstName = firstName;
        this.identifier = identifier;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.requestProcessStatus = requestProcessStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRequestProcessStatus() {
        return requestProcessStatus;
    }

    public void setRequestProcessStatus(String requestProcessStatus) {
        this.requestProcessStatus = requestProcessStatus;
    }
}
