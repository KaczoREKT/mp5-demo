package edu.pja.mas.s28876.mp5demo.repository;

import edu.pja.mas.s28876.mp5demo.model.Manager;
import edu.pja.mas.s28876.mp5demo.model.Programmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProgrammerRepository programmerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    Programmer p1, p2;
    Manager m1;



    @BeforeEach
    public void initData() {
        p1 = Programmer.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .salary(3000)
                .programmingLanguage("Javascript")
                .skills(new HashSet<>(Arrays.asList("Coping from StackOverflow", "Git")))
                .build();

        p2 = Programmer.builder()
                .firstName("Adam")
                .lastName("Nowak")
                .salary(3000)
                .programmingLanguage("Javascript")
                .skills(new HashSet<>(Arrays.asList("Coping from StackOverflow", "Git")))
                .build();
        m1 = Manager.builder()
                .firstName("Anna")
                .lastName("Iksińska")
                .salary(5000)
                .bonus(1000d)
                .build();
    }

    @Test
    public void testRequiredDependencies() {
        assertNotNull(employeeRepository);
        assertNotNull(managerRepository);
        assertNotNull(programmerRepository);
    }

    @Test
    public void testSaveAll(){
        programmerRepository.saveAll(Arrays.asList(p1, p2));
        managerRepository.save(m1);
        entityManager.flush();
        assertEquals(3, employeeRepository.count());
    }
}