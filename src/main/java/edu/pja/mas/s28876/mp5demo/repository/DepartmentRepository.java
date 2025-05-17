package edu.pja.mas.s28876.mp5demo.repository;

import edu.pja.mas.s28876.mp5demo.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    public List<Department> findByName(String name);
    public List<Department> findByNameAndLocation(String name, String location);

    @Query("from Department as d where d.budget > :minBudget")
    public List<Department> findDepartmentsWithBudgetGreaterThan(@Param("minBudget") double minBudget);
}
