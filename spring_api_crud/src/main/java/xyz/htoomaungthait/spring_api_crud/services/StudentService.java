package xyz.htoomaungthait.spring_api_crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.htoomaungthait.spring_api_crud.models.Student;
import xyz.htoomaungthait.spring_api_crud.repositories.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student get(int id){
        return studentRepository.findById(id).get();
    }



    public  void delete(int id){
        studentRepository.deleteById(id);
    }
}
