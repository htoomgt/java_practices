package xyz.htoomaungthait.emsbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.htoomaungthait.emsbackend.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
