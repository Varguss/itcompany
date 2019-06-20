package com.javarush.tutorial.ITCompany.service.dto.team;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateTeamRequest {
    private String name;
}
