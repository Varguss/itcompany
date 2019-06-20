package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.domain.Project;
import com.javarush.tutorial.ITCompany.service.ProjectManager;
import com.javarush.tutorial.ITCompany.service.dto.project.CreateProjectRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("project")
public class ProjectController {
    private final ProjectManager manager;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView showAll() {
        log.info("Showing all projects...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projects");
        return modelAndView;
    }

    @GetMapping("add")
    @ResponseStatus(HttpStatus.OK)
    public String add() {
        return "input";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView create(@RequestParam String name,
                               @RequestParam String description,
                               @RequestParam String customer,
                               @RequestParam BigDecimal profit,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        log.info("Creating project with next data:\nname:{}\ndescription:{}\ncustomer:{}\nprofit:{}\nstart:{}\nend:{}",
                name,
                description,
                customer,
                profit,
                start,
                end
        );

        Project project = manager.save(CreateProjectRequest.builder()
                .name(name)
                .description(description)
                .customer(customer)
                .profit(profit)
                .start(start)
                .end(end)
                .build());

        log.info("Project saved with next data:\n{}", project);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("input");
        return modelAndView;
    }

    @ModelAttribute("projects")
    public List<Project> addProjects() {
        return manager.getAll();
    }
}
