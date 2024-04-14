package com.student.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.student.config.ApplicationConfig;
import com.student.core.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class StudentServiceTest {

//	private ApplicationContext context;
	
	@Inject //because now we use @ContextConfiguration and help to create instance of StudentService
	private StudentService service;

/*	Because we have use @ContextConfiguration annotation so we do need these code anymore
 * @BeforeEach
	void setUp() {
		// define a class path XML application context
//		context = new ClassPathXmlApplicationContext("beans.xml"); 
		// do not need XML now we instead using AnnotationConfigApplicationContext
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		service = context.getBean("studentService", StudentService.class);

	}
	*/

	@Test
	void testGetOneStudent() {
		Student student = service.get(1);
		assertThat(student.getFirstName(), equalTo("Eric"));
		assertThat(student.getSurname(), equalTo("Colbert"));
	}

	@Test
	void tesGetAll() {
		// test that the dao is injected into the service bean
		service.getAllStudents().forEach(stu -> {
			System.out.printf("%-10s %-10s%n", stu.getFirstName(), stu.getSurname());
			System.out.println(stu);
		});
	}
	@Test
	void testStudentsForDepartment(){
		 assertThat(service.getStudentsForDepartments().size(), equalTo(2));
		 service.getAllStudents().forEach(stu -> {
				System.out.printf("%-10s %-10s%n", stu.getFirstName(), stu.getSurname());
				System.out.println(stu);
			});
	}
}
