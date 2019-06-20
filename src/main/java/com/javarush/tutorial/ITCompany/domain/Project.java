package com.javarush.tutorial.ITCompany.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 1024)
    private String description;

    @NotBlank
    @Column(nullable = false)
    private String customer;

    @NotNull
    @DecimalMin("0")
    @Column(nullable = false, precision = 30, scale = 18)
    private BigDecimal profit;

    @FutureOrPresent
    private LocalDateTime end;

    @PastOrPresent
    @Column(nullable = false)
    private LocalDateTime start;

    @OneToOne(mappedBy = "project")
    @Fetch(FetchMode.JOIN)
    private Team team;

    public Project(@NotBlank String name,
                   @NotBlank String description,
                   @NotBlank String customer,
                   @NotNull @DecimalMin("0") BigDecimal profit,
                   @FutureOrPresent LocalDateTime end,
                   @PastOrPresent LocalDateTime start) {
        this.name = name;
        this.description = description;
        this.customer = customer;
        this.profit = profit;
        this.end = end;
        this.start = start;
    }
}