package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstName;
    private String mail;
    private String phoneNumber;
    private Long codeUR;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(){}

    public User(String name, String firstName, String mail, String phoneNumber, Long codeUR, String password) {
        this.name = name;
        this.firstName = firstName;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.codeUR = codeUR;
        Password = password;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCodeUR() {
        return codeUR;
    }

    public void setCodeUR(Long codeUR) {
        this.codeUR = codeUR;
    }
}
