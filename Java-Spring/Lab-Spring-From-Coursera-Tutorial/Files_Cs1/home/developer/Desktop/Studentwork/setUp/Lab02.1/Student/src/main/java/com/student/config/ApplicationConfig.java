package com.student.config;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.*;

import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;
import com.student.service.StudentService;
import com.student.service.StudentServiceImpl;
import com.student.service.StudentServiceProxy;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

	@Bean(name="studentDao")
	public StudentDao dao() {
		return new StudentDaoImpl();
	}
	@Value("${max}") //search the max variable in application.propties file and initialize value in
	private int numberOfStudent;
	
	@Bean(name="studentService")
//	@ConditionalOnExpression("'${env}'.equals('prod')")
	@Conditional(StudentConditional_Prod.class)
	public StudentService service() {
		StudentServiceImpl service = new StudentServiceImpl();
		service.setStudentDao(dao());
		service.setNumberOfStudents(numberOfStudent);
		return service;
	}
	@Bean
	//The "Static" as this must be RESOLVED before any other beans as it is amending meta data.
	//Our sources can be set via the class annotation @PropertySource

	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	} 
		
	@Bean(name="studentService")
//	@ConditionalOnExpression(
//			 "'${env}' == 'test'" 
//	)
	@Conditional(StudentConditional_Test.class)
	StudentService serviceTest(){
		StudentServiceImpl service =  new StudentServiceImpl();
		service.setStudentDao(dao());
		service.setNumberOfStudents(numberOfStudent);
		return  new StudentServiceProxy(service);
	} 


}
