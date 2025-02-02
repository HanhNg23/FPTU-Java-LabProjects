package com.student.controller;

import java.lang.reflect.Executable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;
import com.student.core.Student;
import com.student.exception.MyException;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

 

@RequestMapping("/student")
@RestController
@CrossOrigin
public class StudentController {
	
	 
	@Inject
	private StudentService studentService;
 
	@Inject
	StudentRepository studentRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Student> getAll() {
		return studentService.getAllStudents();
	}
	
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@PathVariable("id") long id) {
		System.out.println("id " + id);
		return studentService.get(id);
	}
	//Get object use repository.findID() which defined in CrudRepository
//	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Student getStudent(@PathVariable("id") Long id) {
//		System.out.println("id " + id);
//		Optional<Long> opt =  Optional.ofNullable(id);
//		return studentService.get_new_verse(opt.orElse(1L));
//	}
	
	@GetMapping(path="/search/department", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getDepartments() {
		 return studentService.getAllStudents().stream().map(p-> p.getDept()).distinct().collect(Collectors.toList());
	}
	
	@GetMapping(path="/search/department/{dept}", produces =  MediaType.APPLICATION_JSON_VALUE)
	public Collection<Student> getStudentsByDepartment(@PathVariable("dept") String dept) {
		return studentService.getStudentsByDepartment(dept);
	}
	
	
//	@PostMapping
//	@Transactional(rollbackFor = MyException.class)
//	//add @Transactional() into Student Repository to apply for function Student save(Student entity)
//	public ResponseEntity<String> add(@RequestBody Student student) throws MyException{
//			studentRepository.save(student);
//			if(student.getFees() > 200.00) {
//				throw new MyException("Blow Up");
//			}
//			//save and then return added student to viewer by build location in response entity 
//			return ResponseEntity.accepted().header("location", "/student/"+ student.getId()).build();
//	}
//
//	//If the proceed error use this to throw exception
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handle (Executable exeption){
//		return ResponseEntity.badRequest().build();
//	}
	@PostMapping
	@Transactional(rollbackFor = MyException.class)
	public ResponseEntity<String> add(@RequestBody Student student) throws MyException{
		studentRepository.save(student);
		if(student.getFees() > 200.00) {
			throw new MyException("Blow Up");
		}
		return ResponseEntity.accepted().header("location", "/student/"+ student.getId()).build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handle(Exception exception) {
		return ResponseEntity.badRequest().build();
	}
	
	
	
 
	 
}
