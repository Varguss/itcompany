package com.javarush.tutorial.ITCompany.controller;

import com.javarush.tutorial.ITCompany.service.TeamManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Validated
@Controller
@AllArgsConstructor
@RequestMapping("team")
public class TeamController {
    private final TeamManager manager;


}
