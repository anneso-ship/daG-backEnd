package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="Agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;
    public String firstName;
    public String email;
    public Long codeAG;
    public String phoneNumber;
    public String password;

    public Agent() {
    }

    public Agent(String name, String firstName, String email, Long codeAG, String phoneNumber, String password) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.codeAG = codeAG;
        this.phoneNumber = phoneNumber;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCodeAG() {
        return codeAG;
    }

    public void setCodeAG(Long codeAG) {
        this.codeAG = codeAG;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
