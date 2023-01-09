package com.example.demo.Service;

import com.example.demo.Model.Administrator;
import com.example.demo.Repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
@Service
public class AdministratorService {

    @Autowired
    PasswordEncoder encoder;


    @Autowired
    public AdministratorRepository administratorRepository;


    public void createAdmin(Administrator administrator){
        administrator.setPassword(encoder.encode(administrator.getPassword()));
        this.administratorRepository.save(administrator);
    }

    public Administrator loginAdmin(Administrator administrator){
        //Optional<Administrator> admin = administratorRepository.findById((long) administrator.getId());
        Optional<Administrator> admin = administratorRepository.findByIdentifier(administrator.getIdentifier());

        if (admin.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        } else {
            if ( encoder.matches(administrator.getPassword(),admin.get().getPassword())
                    && administrator.getIdentifier().equals(admin.get().getIdentifier()) ) {
                return admin.get();
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            }
        }
    }


}
