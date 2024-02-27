package xyz.htoomaungthait.spring_api_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.htoomaungthait.spring_api_crud.models.Student;
import xyz.htoomaungthait.spring_api_crud.services.StudentService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAll")
    public List<Student> list() {
        return studentService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.save(student);
        return "New student added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id){
        try {
            Student existStudent = studentService.get(id);
            student.setId(existStudent.getId());
            studentService.save(student);
            return new ResponseEntity<Student>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        try {
            Student exitStudent = studentService.get(id);
            if(exitStudent != null){
                studentService.delete(id);
            }

        } catch (NoSuchElementException e) {
            return "Student not found";
        }

        return "Student deleted";
    }
}
