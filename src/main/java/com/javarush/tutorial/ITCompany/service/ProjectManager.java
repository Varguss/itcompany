package com.javarush.tutorial.ITCompany.service;

import com.javarush.tutorial.ITCompany.domain.Project;
import com.javarush.tutorial.ITCompany.repository.ProjectRepository;
import com.javarush.tutorial.ITCompany.service.dto.project.CreateProjectRequest;
import com.javarush.tutorial.ITCompany.service.exception.NoProjectFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProjectManager {
    private final ProjectRepository repository;

    @Transactional(readOnly = true)
    public List<Project> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Project get(long id) throws NoProjectFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NoProjectFoundException(String.format(
                        "No project found by id %d",
                        id
                )));
    }

    @Transactional
    public Project save(CreateProjectRequest request) {
        Project project = new Project(
                request.getName(),
                request.getDescription(),
                request.getCustomer(),
                request.getProfit(),
                request.getEnd(),
                request.getStart()
        );

        repository.save(project);
        return project;
    }
}
