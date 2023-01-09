package com.example.demo.Service;

import com.example.demo.Model.BirthCertificate;
import com.example.demo.Repository.BirthCertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirthCertificateService {

    @Autowired
    public BirthCertificateRepository birthCertificateRepository;

    //Ajouter un acte de naissance
    public BirthCertificate createBirthCertificate(BirthCertificate birthCertificate){
        return this.birthCertificateRepository.save(birthCertificate);
    }

    //Lister tous les actes de naissances enregistrés
    public List<BirthCertificate> getAllBirthCertificate() {
        return this.birthCertificateRepository.findAll();
    }

    public Optional<BirthCertificate> getBirthCertificateById(int id){
        return this.birthCertificateRepository.findById(id);
    }

    public BirthCertificate updatebirthcertificate(int id,BirthCertificate birthCertificate){

        BirthCertificate bc = birthCertificateRepository.findById(id).get();

        //Mise à jour des données de l'enfant
        bc.setName(birthCertificate.getName());     bc.setFirstName(birthCertificate.getFirstName());
        bc.setGender(birthCertificate.getGender()); bc.setBirthDate(birthCertificate.getBirthDate());
        bc.setNationality(birthCertificate.getNationality());

        //Mise à jour des données de la mère de l'enfant
        bc.setNameMum(birthCertificate.getNameMum());   bc.setFirstNameMum(birthCertificate.getFirstNameMum());
        bc.setBirthDateMum(birthCertificate.getBirthDateMum()); bc.setProfessionMum(birthCertificate.getProfessionMum());
        bc.setNationalityMum(birthCertificate.getNationalityMum());

        //Mise à jour des données du père de l'enfant
        bc.setNameDad(birthCertificate.getNameDad());   bc.setFirstNameDad(birthCertificate.getFirstNameDad());
        bc.setBirthDateDad(birthCertificate.getBirthDateDad()); bc.setProfessionDad(birthCertificate.getProfessionDad());
        bc.setNationalityDad(birthCertificate.getNationalityDad());

        return birthCertificateRepository.save(bc);
    }



}
