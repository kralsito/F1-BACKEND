package com.api.crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}
