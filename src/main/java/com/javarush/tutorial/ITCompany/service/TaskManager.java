package com.javarush.tutorial.ITCompany.service;

import com.javarush.tutorial.ITCompany.domain.Task;
import com.javarush.tutorial.ITCompany.repository.TaskRepository;
import com.javarush.tutorial.ITCompany.service.dto.task.CreateTaskRequest;
import com.javarush.tutorial.ITCompany.service.exception.NoTaskFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TaskManager {
    private final TaskRepository repository;

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Task get(long id) throws NoTaskFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NoTaskFoundException(String.format(
                        "Task by id %d is not found",
                        id
                )));
    }

    @Transactional
    public Task save(CreateTaskRequest request) {
        Task task = new Task(
                request.getName(),
                request.getDescription(),
                request.getDifficultyCoefficient()
        );

        repository.save(task);
        return task;
    }
}
