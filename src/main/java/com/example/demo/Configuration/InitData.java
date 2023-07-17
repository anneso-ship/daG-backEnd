package com.example.demo.Configuration;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Agent;
import com.example.demo.Model.User;
import com.example.demo.Repository.AdministratorRepository;
import com.example.demo.Repository.AgentRepository;
import com.example.demo.Repository.BirthCertificateRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AdministratorService;
import com.example.demo.Service.AgentService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public AdministratorService administratorService;


    @Autowired
    AgentService agentService;

    public static Random random = new Random();

    @Autowired
    UserService userService;

    @Autowired
    public AdministratorRepository administratorRepository;

    @Autowired
    public AgentRepository agentRepository;

    @Autowired
    public UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }




    @Override
    public void run(String... args) throws Exception {

    }

}
