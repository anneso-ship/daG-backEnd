package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;
    public String firstName;
    public String identifier;
    public String password;
    public String email;
    public String phoneNumber;
    public String  role;
    public String statusProcess;


    public Agent() {
    }

    public Agent(String name, String firstName,
                 String identifier, String password,
                 String email, String phoneNumber,
                 String role, String statusProcess) {
        this.name = name;
        this.firstName = firstName;
        this.identifier = identifier;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.statusProcess = statusProcess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatusProcess() {
        return statusProcess;
    }

    public void setStatusProcess(String statusProcess) {
        this.statusProcess = statusProcess;
    }
}
