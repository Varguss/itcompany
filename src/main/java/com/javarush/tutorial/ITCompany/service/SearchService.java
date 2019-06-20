package com.javarush.tutorial.ITCompany.service;

import com.javarush.tutorial.ITCompany.domain.Developer;
import com.javarush.tutorial.ITCompany.domain.Project;
import com.javarush.tutorial.ITCompany.domain.Task;
import com.javarush.tutorial.ITCompany.service.exception.NoDeveloperFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SearchService {
    private final DeveloperManager developerManager;
    private final ProjectManager projectManager;
    private final TaskManager taskManager;

    public List<Task> getTasksByDeveloperName(String developerName) throws NoDeveloperFoundException {
        List<Developer> developers = developerManager.getAllByName(developerName);
        Developer developer = developers.get(0);
        return taskManager.getAll();
    }

    public List<Project> getProjectsByDeveloperName(String developerName) throws NoDeveloperFoundException {
        List<Developer> developers = developerManager.getAllByName(developerName);
        Developer developer = developers.get(0);
        return projectManager.getAll();
    }
}
