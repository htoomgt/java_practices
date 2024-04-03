package xyz.htoomaungthait.JPA.paging.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.htoomaungthait.JPA.paging.models.Person;
import xyz.htoomaungthait.JPA.paging.repositories.PersonRepository;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/test")
    public String testIndex(){
        return "this is api for people controller!";
    }

    @GetMapping
    public Page<Person> findAll(@RequestParam int page, @RequestParam int size){
        Pageable pr = PageRequest.of(page - 1, size);
        return  this.repository.findAll(pr);
    }

}
