package com.javarush.tutorial.ITCompany.repository;

import com.javarush.tutorial.ITCompany.domain.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    List<Developer> findAllByName(String name);
}