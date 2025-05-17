package edu.pja.mas.s28876.mp5demo.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
}
