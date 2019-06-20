package com.javarush.tutorial.ITCompany.service.dto.developer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateDeveloperRequest {
    private String name;
    private String position;
}