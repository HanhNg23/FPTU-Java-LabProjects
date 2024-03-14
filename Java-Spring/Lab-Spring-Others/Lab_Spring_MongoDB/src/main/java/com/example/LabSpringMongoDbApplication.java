package com.example;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.service.StudentService;

@SpringBootApplication
public class LabSpringMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabSpringMongoDbApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(StudentService service) {
	    return args -> {
		service.setUpStudent();
	    };
	}

}
