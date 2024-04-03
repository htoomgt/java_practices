package xyz.htoomaungthait.JPA.paging.data;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.htoomaungthait.JPA.paging.models.Address;
import xyz.htoomaungthait.JPA.paging.models.Person;
import xyz.htoomaungthait.JPA.paging.repositories.PersonRepository;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository repository;

    public SampleDataLoader(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.logger.info("Loading Sample Data ...");

        Person person = new Person(
                "John", "Doe", "09793432709", "johndoe@gmail.com",
                new Address("Street", "City", "state", "zip")
        );

        this.repository.save(person);

        this.logger.info("sample data saved");

        // Create 100 rows of people  in the database
//        List<Person> people =




    }
}
