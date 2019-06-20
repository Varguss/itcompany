package com.javarush.tutorial.ITCompany.repository;

import com.javarush.tutorial.ITCompany.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
