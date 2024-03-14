package com.student.service;

import java.util.Collection;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.student.core.Student;
import com.student.repository.StudentRepository;
 
@Named
public class StudentServiceImpl implements StudentService {
 
//	@PersistenceContext //do not need because we use the Student Repository instead	
//	private EntityManager entity;
	 
	@Inject
	private StudentRepository studentRepository;
 
	 
	@Override
	public Student get(long id) {
		//Note : when use this getOne() function we have the trouble in returning the result object in Json formate because getOne() is used to load obj in lazy loading 
		//To avoid this --> add @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) annotation into class Student.java
		Student student = studentRepository.getOne(id);  
		System.out.println("student " + student.getFirstName());
		return student;
	}
	
	@Override
	public Student get_new_verse(Long id) {
		Optional<Student> result = studentRepository.findById(id);
		return result.orElse(null);
	}

	@Override
	public Collection<Student> getAllStudents() {
		 return studentRepository.findAll();
 	}

//	@Override
//	public Collection<Student> getStudentsByDepartment(String department) {
//		return studentRepository.findBydept(department);
//	}
	
	
	@Override
	public Collection<Student> getStudentsByDepartment(String department) {
		return studentRepository.getByDept(department);
	}
 
}
