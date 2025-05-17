package edu.pja.mas.s28876.mp5demo;

import edu.pja.mas.s28876.mp5demo.model.Department;
import edu.pja.mas.s28876.mp5demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final DepartmentRepository departmentRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        System.out.println("Data initialized");
        Iterable<Department> all = departmentRepository.findAll();
        System.out.println(all);
    }
}

