package com.javarush.tutorial.ITCompany.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id", nullable = false)
    private Developer leader;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Developer> developers;

    public Team(String name, Project project, Developer leader, Set<Developer> developers) {
        this.name = name;
        this.project = project;
        this.leader = leader;
        this.developers = developers;
    }

    public Team(String name, Project project, Developer leader) {
        this.name = name;
        this.project = project;
        this.leader = leader;
    }

    public Team(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    public Team(String name) {
        this.name = name;
    }
}
