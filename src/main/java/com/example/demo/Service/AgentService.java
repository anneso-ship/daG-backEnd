package com.example.demo.Service;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Agent;
import com.example.demo.Model.BirthCertificate;
import com.example.demo.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public AgentRepository agentRepository;


    public void createAgent(Agent agent){
        agent.setPassword(encoder.encode(agent.getPassword()));
        this.agentRepository.save(agent);
    }

    public Agent loginAgent(Agent agent){
        Optional<Agent> agentDb = agentRepository.findByEmail(agent.getEmail());
        if (agentDb.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        } else {
            if ( encoder.matches(agent.getPassword(),agentDb.get().getPassword())
                    && agent.getEmail().equals(agentDb.get().getEmail()) &&
                    agent.getIdentifier().equals(agentDb.get().getIdentifier())) {
                return agentDb.get();
            } else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            }
        }
    }



    public List<Agent> getAllAgent() {
        return this.agentRepository.findAll();
    }


}
