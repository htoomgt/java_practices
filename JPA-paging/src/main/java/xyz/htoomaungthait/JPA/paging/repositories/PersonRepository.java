package xyz.htoomaungthait.JPA.paging.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import xyz.htoomaungthait.JPA.paging.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Page<Person> findAll(Pageable pr);
}
