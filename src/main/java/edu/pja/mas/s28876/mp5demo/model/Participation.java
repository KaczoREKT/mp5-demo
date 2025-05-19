package edu.pja.mas.s28876.mp5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"programmer_id", "project_id"})
})
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programmer_id", nullable = false)
    @NotNull
    private Programmer programmer;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Project project;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;
}
