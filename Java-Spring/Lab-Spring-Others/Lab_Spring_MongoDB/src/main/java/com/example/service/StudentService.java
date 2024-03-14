package com.example.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.example.model.Address;
import com.example.model.Gender;
import com.example.model.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
   
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    
    public List<Student> getAllSrudents() {
	return repository.findAll();
    }
    
    public void createNewStudents(Student student) {
	student.setCreatedAt(LocalDateTime.now());
	checkAndInsertStudentWithMethodName(student);
    }

    public void setUpStudent() {
	Address address = Address.builder()
		.country("Vietname")
		.city("Ho Chi Minh")
		.postCode("NE9")
		.build();
	
	Student student = Student.builder()
		.firstName("Jamila")
		.lastName("Ahmed")
		.email("jahmed@gmail.com")
		.gender(Gender.FEMALE)
		.address(address)
		.favouriteSubjects(List.of("Computer Science","Mathematic"))
		.totalSpentInBooks(10)
		.createdAt(LocalDateTime.now())
		.build();
	
	//checkAndInsertStudentWithMongoTemplate(student);
	checkAndInsertStudentWithMethodName(student);
	
	
    }
    
    public void checkAndInsertStudentWithMongoTemplate(Student student) {
	Query query = new Query();
	query.addCriteria(Criteria.where("email").is(student.getEmail()));
	List<Student> students = mongoTemplate.find(query, Student.class);
	
	
	if(students.size() > 1) {
	    throw new IllegalStateException(
		    "Found many students with email " + student.getEmail());
	}
	if(students.isEmpty()) {
	    repository.insert(student);
	    System.out.println("Success");
	}else {
	    System.out.println(student.getEmail() + " already exists");
	}
    }
    
    public void checkAndInsertStudentWithMethodName(Student student) {
 	
	repository.findStudentByEmail(student.getEmail()).ifPresentOrElse(st -> {
	    System.out.println(student.getEmail() + " already exists");
	}, () -> {
	    repository.insert(student);
	    System.out.println("Success");
	});

    }
    
}
