package edu.pja.mas.s28876.mp5demo.repository;

import edu.pja.mas.s28876.mp5demo.model.Department;
import edu.pja.mas.s28876.mp5demo.model.Programmer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssociationTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;


    Programmer p1;
    Department d4;
    @Autowired
    private ProgrammerRepository programmerRepository;

    @BeforeEach
    public void initData() {
        d4 = Department.builder()
                .name("Dept 1")
                .location("Loc 3")
                .budget(1000)
                .build();
        p1 = Programmer.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .salary(3000)
                .programmingLanguage("JavaScript")
                .skills(new HashSet<>(Arrays.asList("Coping from StackOverflow", "Git")))
                .build();
    }

    @Test
    public void testSave(){
        d4.getEmployees().add(p1);
        departmentRepository.save(d4);
        p1.setWorksIn(d4);
        programmerRepository.save(p1);

        Optional<Department> byId = departmentRepository.findById(d4.getId());
        assertTrue(byId.isPresent());
        System.out.println(byId.get().getEmployees());
        assertEquals(1, byId.get().getEmployees().size());
    }
}