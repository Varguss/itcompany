package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("search")
public class SearchController {
    private final SearchService service;

    @GetMapping
    public ModelAndView searchPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("output");

        return modelAndView;
    }

    @PostMapping
    public ModelAndView search(@RequestParam(required = false) String developerName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("output");

        if (developerName != null && !developerName.isEmpty()) {
            modelAndView.addObject("tasks", service.getTasksByDeveloperName(developerName));
            modelAndView.addObject("projects", service.getProjectsByDeveloperName(developerName));
        }

        return modelAndView;
    }
}
