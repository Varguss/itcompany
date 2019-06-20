package com.javarush.tutorial.ITCompany.service;

import com.javarush.tutorial.ITCompany.domain.Team;
import com.javarush.tutorial.ITCompany.repository.TeamRepository;
import com.javarush.tutorial.ITCompany.service.dto.team.CreateTeamRequest;
import com.javarush.tutorial.ITCompany.service.exception.NoTeamFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamManager {
    private final TeamRepository repository;

    @Transactional(readOnly = true)
    public List<Team> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Team get(long id) throws NoTeamFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NoTeamFoundException(String.format(
                        "Team by id %d is not found",
                        id
                )));
    }

    @Transactional
    public Team save(CreateTeamRequest request) {
        Team team = new Team(
                request.getName()
        );

        repository.save(team);
        return team;
    }
}