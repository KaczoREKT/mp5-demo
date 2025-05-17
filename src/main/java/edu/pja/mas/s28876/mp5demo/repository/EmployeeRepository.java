package edu.pja.mas.s28876.mp5demo.repository;

import edu.pja.mas.s28876.mp5demo.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
