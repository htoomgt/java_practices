package xyz.htoomaungthait.spring_api_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.htoomaungthait.spring_api_crud.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}



