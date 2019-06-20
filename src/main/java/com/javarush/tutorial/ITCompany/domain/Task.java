package com.javarush.tutorial.ITCompany.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    @DecimalMin("0")
    @DecimalMax("10")
    @Column(nullable = false, precision = 30, scale = 18)
    private BigDecimal difficultyCoefficient;

    public Task(@NotBlank String name,
                @NotBlank String description,
                @DecimalMin("0") @DecimalMax("10") BigDecimal difficultyCoefficient) {
        this.name = name;
        this.description = description;
        this.difficultyCoefficient = difficultyCoefficient;
    }
}
