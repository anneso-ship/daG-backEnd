package com.example.demo.Controller;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Agent;
import com.example.demo.Model.BirthCertificate;
import com.example.demo.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("agent")
public class AgentController {


    @Autowired
    private AgentService agentService;

    //requete création user
    @PostMapping(value = "agentRegistration")
    public void addUser(@RequestBody Agent agent){
        System.out.println(agent);
        agentService.createAgent(agent);
    }

    //requete connexion d'un agent
    @PostMapping(value = "authenticate")
    public Agent authenticate(@RequestBody Agent agent) {
        return agentService.loginAgent(agent);
    }

    //Afficher les agents
    @GetMapping(value= "get_agents_details")
    public List<Agent> getAllAgent(){
        return agentService.getAllAgent();
    }



}
