package com.example.schedullartasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*The @EnableScheduling annotation ensures that a background task
 *executor is created. Without it, nothing gets scheduled.*/
public class SchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingTasksApplication.class, args);
	}

}
