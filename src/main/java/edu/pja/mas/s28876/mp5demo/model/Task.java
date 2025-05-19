package edu.pja.mas.s28876.mp5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private Project owner;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
}
