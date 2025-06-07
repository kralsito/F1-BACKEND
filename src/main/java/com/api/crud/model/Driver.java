package com.api.crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
