package com.javarush.tutorial.ITCompany.service.dto.task;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class CreateTaskRequest {
    private String name;
    private String description;
    private BigDecimal difficultyCoefficient;
}
