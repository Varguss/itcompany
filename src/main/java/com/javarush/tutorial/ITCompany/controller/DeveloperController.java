package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.domain.Developer;
import com.javarush.tutorial.ITCompany.service.DeveloperManager;
import com.javarush.tutorial.ITCompany.service.dto.developer.CreateDeveloperRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("developer")
public class DeveloperController {
    private final DeveloperManager manager;

    @GetMapping("add")
    public String add() {
        return "inputDeveloper";
    }

    @PostMapping
    public ModelAndView create(@RequestParam String name, @RequestParam String position) {
        Developer developer = manager.save(CreateDeveloperRequest.builder()
                .name(name)
                .position(position)
                .build());

        log.info("Created developer with next data:\n{}", developer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("inputDeveloper");
        return modelAndView;
    }

    @ModelAttribute("developers")
    public List<Developer> addDevelopers() {
        return manager.getAll();
    }
}
