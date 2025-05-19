package edu.pja.mas.s28876.mp5demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Programmer extends Employee {

    @NotBlank
    private String programmingLanguage;

    @ElementCollection
    @CollectionTable(name ="programmer_skill", joinColumns = @JoinColumn(name="programmer_id"))
    @Builder.Default
    private Set<String> skills = new HashSet<>();

    @OneToMany(mappedBy = "programmer", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Participation> participations;

}
