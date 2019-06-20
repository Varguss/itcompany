package com.javarush.tutorial.ITCompany.repository;

import com.javarush.tutorial.ITCompany.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
