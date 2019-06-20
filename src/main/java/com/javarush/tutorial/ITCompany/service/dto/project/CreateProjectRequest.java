package com.javarush.tutorial.ITCompany.service.dto.project;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@Builder
public class CreateProjectRequest {
    private String name;
    private String description;
    private String customer;
    private BigDecimal profit;
    private LocalDateTime end;
    private LocalDateTime start;
}
