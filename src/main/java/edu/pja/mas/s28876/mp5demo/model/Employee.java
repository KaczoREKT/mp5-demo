package edu.pja.mas.s28876.mp5demo.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Department worksIn;
}
