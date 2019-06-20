package com.javarush.tutorial.ITCompany.service;

import com.javarush.tutorial.ITCompany.domain.Developer;
import com.javarush.tutorial.ITCompany.repository.DeveloperRepository;
import com.javarush.tutorial.ITCompany.service.dto.developer.CreateDeveloperRequest;
import com.javarush.tutorial.ITCompany.service.exception.NoDeveloperFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class DeveloperManager {
    private final DeveloperRepository repository;

    @Transactional(readOnly = true)
    public List<Developer> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Developer> getAllByName(String name) {
        return repository.findAllByName(name);
    }

    @Transactional(readOnly = true)
    public Developer get(long id) throws NoDeveloperFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NoDeveloperFoundException(String.format(
                        "Developer by id %d is not found!",
                        id
                )));
    }

    @Transactional
    public Developer save(CreateDeveloperRequest request) {
        Developer developer = new Developer(
                request.getName(),
                request.getPosition()
        );

        repository.save(developer);
        return developer;
    }
}