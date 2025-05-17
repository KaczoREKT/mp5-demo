package edu.pja.mas.s28876.mp5demo.repository;

import edu.pja.mas.s28876.mp5demo.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;



    Department d4;

    @BeforeEach
    public void initData() {
        d4 = Department.builder()
                .name("Dept 1")
                .location("Loc 3")
                .budget(1000)
                .build();
    }
    @Test
    public void testRequiredDependencies(){
        assertNotNull(departmentRepository);
    }

    @Test
    public void testFetchDepartments(){
        Iterable<Department> all = departmentRepository.findAll();
        for (Department department : all) {
            System.out.println(department);
        }
    }

    @Test
    public void testSaveDepartment(){
        departmentRepository.save(d4);
        entityManager.flush();
        long count = departmentRepository.count();
        assertEquals(3, count);
    }

    @Test
    public void testSaveInvalidDepartmentBudget(){
        assertThrows(ConstraintViolationException.class, () -> {
            d4.setBudget(-1000d);
            departmentRepository.save(d4);
            entityManager.flush();
        });
    }

    @Test
    public void testFindByName(){
        List<Department> production = departmentRepository.findByName("Production");
        System.out.println(production);
        assertEquals(1, production.size());
    }

    @Test
    public void testFindByNameAndLocation(){
        List<Department> sales = departmentRepository.findByNameAndLocation("Sales", "Barbie");
        System.out.println(sales);
        assertEquals(1, sales.size());
    }

    @Test
    public void testFindByBudgetGreaterThan(){
        List <Department> res = departmentRepository.findDepartmentsWithBudgetGreaterThan(50000);
        System.out.println(res);
        assertEquals(1, res.size());
    }
}