package edu.pja.mas.s28876.mp5demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
}
