package com.example.demo.Service;

import com.example.demo.Model.Agent;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public UserRepository userRepository;

    //créer utilisateur
    public void createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public User loginUser(User user){
        Optional <User> userDb = userRepository.findByFirstName(user.getFirstName());
        if (userDb.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        } else {
            if ( encoder.matches(user.getPassword(),userDb.get().getPassword())
                    && user.getEmail().equals(userDb.get().getEmail()) ) {
                return userDb.get();
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            }
        }
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    //supprimer un utilisateur grace a son nom
    public void deleteUserByName(String name){this.userRepository.deleteByName(name);}

    //retrouver un utilisateur grace à son nom
    public List<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    //retrouver un utilisateur grace à son prénom
    public Optional<User> getUserByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

}
