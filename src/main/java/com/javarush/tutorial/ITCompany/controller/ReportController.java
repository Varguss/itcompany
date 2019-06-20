package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.service.DeveloperManager;
import com.javarush.tutorial.ITCompany.service.ProjectManager;
import com.javarush.tutorial.ITCompany.service.TaskManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("report")
public class ReportController {
    private final TaskManager taskManager;
    private final ProjectManager projectManager;
    private final DeveloperManager developerManager;

    @GetMapping
    public ModelAndView report() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("report");

        modelAndView.addObject("tasks", taskManager.getAll());
        modelAndView.addObject("projects", projectManager.getAll());
        modelAndView.addObject("developers", developerManager.getAll());

        return modelAndView;
    }
}
