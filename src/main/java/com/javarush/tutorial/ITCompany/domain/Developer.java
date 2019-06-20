package com.javarush.tutorial.ITCompany.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
public class Developer {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    public Developer(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Developer(String name, String position, Team team) {
        this.name = name;
        this.position = position;
        this.team = team;
    }

    public Developer(String name, String position, Team team, Task task) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.task = task;
    }
}
