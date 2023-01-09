package com.example.demo.Controller;
import javax.validation.Valid;
import com.example.demo.Model.BirthCertificate;
import com.example.demo.Repository.BirthCertificateRepository;
import com.example.demo.Service.BirthCertificateService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BirthCertificateController {

    @Autowired
    public BirthCertificateService birthCertificateService;

    public BirthCertificateRepository birthCertificateRepository;

    //requete création acte de naissance
    @PostMapping(value = "newBirthCertificate")
    public BirthCertificate addBirthCertificate(@RequestBody BirthCertificate birthCertificate){
        System.out.println(birthCertificate);
        return birthCertificateService.createBirthCertificate(birthCertificate);
    }

    //Afficher les actes de naissances
    @GetMapping(value= "getAllBirthCertificate")
    public List<BirthCertificate> getAllBirthCertificate(){
        return birthCertificateService.getAllBirthCertificate();
    }


    @GetMapping(value= "getBirthCertificateById/{id}")
    public BirthCertificate getBirthCertificatebyId(@PathVariable("id") int id){
        return this.birthCertificateService.getBirthCertificateById(id).get();
    }

    @PutMapping(value="updateBirthCertificate/{id}")
    public BirthCertificate updateBirthCertificate(@PathVariable("id") int id, @RequestBody  BirthCertificate birthCertificateDetails ){
        return birthCertificateService.updatebirthcertificate(id,birthCertificateDetails);
    }





}





