package com.example.demo.Model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="birthcertificate")
public class BirthCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Informations sur l'enfant
    String name;
    String firstName;
    String gender;
    Date birthDate;
    String nationality;

    //Informations sur la mère de l'enfant
    String nameMum;
    String firstNameMum;
    Date birthDateMum;
    String professionMum;
    String nationalityMum;


    //Informations sur la père de l'enfant
    String nameDad;
    String firstNameDad;
    Date birthDateDad;
    String professionDad;
    String nationalityDad;

    public BirthCertificate() {
    }

    public BirthCertificate(String name, String firstName,
                            String gender, Date birthDate,
                            String nationality, String nameMum,
                            String firstNameMum, Date birthDateMum,
                            String professionMum, String nationalityMum,
                            String nameDad, String firstNameDad,
                            Date birthDateDad, String professionDad,
                            String nationalityDad) {
        this.id = id;

        this.name = name;
        this.firstName = firstName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.nationality = nationality;

        this.nameMum = nameMum;
        this.firstNameMum = firstNameMum;
        this.birthDateMum = birthDateMum;
        this.professionMum = professionMum;
        this.nationalityMum = nationalityMum;

        this.nameDad = nameDad;
        this.firstNameDad = firstNameDad;
        this.birthDateDad = birthDateDad;
        this.professionDad = professionDad;
        this.nationalityDad = nationalityDad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNameMum() {
        return nameMum;
    }

    public void setNameMum(String nameMum) {
        this.nameMum = nameMum;
    }

    public String getFirstNameMum() {
        return firstNameMum;
    }

    public void setFirstNameMum(String firstNameMum) {
        this.firstNameMum = firstNameMum;
    }

    public Date getBirthDateMum() {
        return birthDateMum;
    }

    public void setBirthDateMum(Date birthDateMum) {
        this.birthDateMum = birthDateMum;
    }

    public String getProfessionMum() {
        return professionMum;
    }

    public void setProfessionMum(String professionMum) {
        this.professionMum = professionMum;
    }

    public String getNationalityMum() {
        return nationalityMum;
    }

    public void setNationalityMum(String nationalityMum) {
        this.nationalityMum = nationalityMum;
    }

    public String getNameDad() {
        return nameDad;
    }

    public void setNameDad(String nameDad) {
        this.nameDad = nameDad;
    }

    public String getFirstNameDad() {
        return firstNameDad;
    }

    public void setFirstNameDad(String firstNameDad) {
        this.firstNameDad = firstNameDad;
    }

    public Date getBirthDateDad() {
        return birthDateDad;
    }

    public void setBirthDateDad(Date birthDateDad) {
        this.birthDateDad = birthDateDad;
    }

    public String getProfessionDad() {
        return professionDad;
    }

    public void setProfessionDad(String professionDad) {
        this.professionDad = professionDad;
    }

    public String getNationalityDad() {
        return nationalityDad;
    }

    public void setNationalityDad(String nationalityDad) {
        this.nationalityDad = nationalityDad;
    }
}
