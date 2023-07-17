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

import com.example.demo.Service.EmailSender;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgentService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public AgentRepository agentRepository;

    String Subject = "Inscription en attente";
    String body = "";


    public void createAgent(Agent agent){
        body = Subject +
                "\n" +
                "Cher(e)"+ agent.getName() + agent.getFirstName() + ","+"\n" +
                "\n" +
                "Nous avons bien reçu votre demande d'inscription et nous vous remercions de votre intérêt pour notre service. Nous sommes en train de traiter votre demande et vous recevrez un numéro d'identification unique dans les plus brefs délais.\n" +
                "\n" +
                "Une fois que vous aurez reçu votre numéro d'identification unique, vous pourrez vous connecter à notre service en utilisant votre adresse e-mail et votre numéro d'identification unique.\n" +
                "\n" +
                "Nous travaillons dur pour traiter votre demande dans les plus brefs délais. Si vous avez des questions ou des préoccupations, n'hésitez pas à nous contacter à l'adresse e-mail suivante : [votre adresse e-mail de contact].\n" +
                "\n" +
                "Merci de votre patience et de votre compréhension.\n" +
                "\n" +
                "Cordialement,";
        agent.setPassword(encoder.encode(agent.getPassword()));
        this.agentRepository.save(agent);
        emailSender.sendEmail(agent.getEmail(),Subject,body);

    }

    public void acceptRequestAgentRegistration(){

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


    public List<Agent> getRequest() {
        // récupérer tous les agents depuis le repository
        List<Agent> allAgents = agentRepository.findAll();

        // filtrer les agents dont le numéro identifier est null
        List<Agent> filteredAgents = allAgents.stream()
                .filter(agent -> agent.getIdentifier() == null)
                .collect(Collectors.toList());

        return filteredAgents;
    }
}
