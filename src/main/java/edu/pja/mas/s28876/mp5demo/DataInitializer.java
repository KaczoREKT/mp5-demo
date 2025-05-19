package edu.pja.mas.s28876.mp5demo;

import edu.pja.mas.s28876.mp5demo.model.Department;
import edu.pja.mas.s28876.mp5demo.model.Programmer;
import edu.pja.mas.s28876.mp5demo.repository.DepartmentRepository;
import edu.pja.mas.s28876.mp5demo.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final DepartmentRepository departmentRepository;
    private final ProgrammerRepository programmerRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        System.out.println("Data initialized");
        Iterable<Department> all = departmentRepository.findAll();
        System.out.println(all);
        Department d = all.iterator().next();
        Programmer p1 = Programmer.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .salary(3000)
                .programmingLanguage("JavaScript")
                .skills(new HashSet<>(Arrays.asList("Coping from StackOverflow", "Git")))
                .build();
        programmerRepository.save(p1);
    }
}

