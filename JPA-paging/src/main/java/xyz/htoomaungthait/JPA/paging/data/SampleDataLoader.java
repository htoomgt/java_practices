package xyz.htoomaungthait.JPA.paging.data;

import com.github.javafaker.Faker;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.htoomaungthait.JPA.paging.models.Address;
import xyz.htoomaungthait.JPA.paging.models.Person;
import xyz.htoomaungthait.JPA.paging.repositories.PersonRepository;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
    private final PersonRepository repository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository repository, Faker faker) {

        this.repository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        this.logger.info("Loading Sample Data ...");

        /*Person person = new Person(
                "John", "Doe", "09793432709", "johndoe@gmail.com",
                new Address("Street", "City", "state", "zip")
        );

        this.repository.save(person);*/

        // Create 100 rows of people  in the database
        List<Person> peoples =  IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Person(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().cellPhone(),
                        faker.internet().emailAddress(),
                        new Address(
                                faker.address().streetAddress(),
                                faker.address().city(),
                                faker.address().state(),
                                faker.address().zipCode()
                        )
                ))
                .toList();
        this.repository.saveAll(peoples);

        this.logger.info("sample data saved");






    }
}
