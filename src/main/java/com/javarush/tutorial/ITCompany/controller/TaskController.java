package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.domain.Task;
import com.javarush.tutorial.ITCompany.service.TaskManager;
import com.javarush.tutorial.ITCompany.service.dto.task.CreateTaskRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("task")
public class TaskController {
    private final TaskManager manager;

    @GetMapping("add")
    public String add() {
        return "inputTask";
    }

    @PostMapping
    public ModelAndView create(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam BigDecimal difficultCoefficient) {
        manager.save(CreateTaskRequest.builder()
                .name(name)
                .description(description)
                .difficultyCoefficient(difficultCoefficient)
                .build());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inputTask");
        return modelAndView;
    }

    @ModelAttribute("tasks")
    public List<Task> addTasks() {
        return manager.getAll();
    }
}
