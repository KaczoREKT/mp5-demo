package edu.pja.mas.s28876.mp5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty.")
    @Size(min = 2, max = 255)
    private String name;

    @NotBlank(message = "Location cannot be empty.")
    @Size(min = 2, max = 255)
    private String location;

    @Min(0)
    private double budget;

    @OneToMany(mappedBy = "worksIn", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> employees = new HashSet<>();
}
