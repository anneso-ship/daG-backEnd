package com.example.demo.Repository;

import com.example.demo.Model.BirthCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BirthCertificateRepository extends JpaRepository <BirthCertificate, Integer> {

    List<BirthCertificate> findByName(String name);

    List<BirthCertificate> findByFirstName(String name);
}
