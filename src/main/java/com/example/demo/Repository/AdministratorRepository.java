package com.example.demo.Repository;

import com.example.demo.Model.Administrator;
import com.example.demo.Model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> findByIdentifier(String identifier);
}
