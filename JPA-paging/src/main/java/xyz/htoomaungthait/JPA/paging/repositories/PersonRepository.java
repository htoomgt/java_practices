package xyz.htoomaungthait.JPA.paging.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.htoomaungthait.JPA.paging.models.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

}
