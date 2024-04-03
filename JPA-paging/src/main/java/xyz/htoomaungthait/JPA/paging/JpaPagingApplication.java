package xyz.htoomaungthait.JPA.paging;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaPagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPagingApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			//System.out.println("Command Line Runner");
		};
	}*/

	@Bean
	Faker faker(){
		return new Faker();
	}

}
