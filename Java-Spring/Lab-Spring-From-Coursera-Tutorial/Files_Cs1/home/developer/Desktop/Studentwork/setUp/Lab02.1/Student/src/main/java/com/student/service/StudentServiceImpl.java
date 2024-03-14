package com.student.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.student.core.Student;
import com.student.dao.StudentDao;

//@Named("studentService") remove to check the JavaConfig in ApplicationConfig
public class StudentServiceImpl implements StudentService {
	//@Inject @Named("studentDao")//scan the beandefinition(the classes has bean managed by Spring IoC) 
	                            //which has name studentDao and create new instance to inject and to initialize value for the studentDao below
	private StudentDao studentDao; 
	//@Value("2") remove to check the JavaConfig in ApplicationConfig
	private int numberOfStudents;

	//cause we have used the inject annotation so do not need to implement setter method
//	public void setStudentDao(StudentDao studentDao) {
//		this.studentDao = studentDao;
//	}
//	public void setNumberOfStudents(int numberOfStudents) {
//		this.numberOfStudents = numberOfStudents;
//	}
	

	@Override
	public Student get(long id) {
		return studentDao.getOne(id);
	}

	@Override
	public Collection<Student> getAllStudents() {
		//get 2 first elements in the list
		return studentDao.getAll().stream().limit(numberOfStudents).collect(Collectors.toList());
	}
	//Now to check the JavaConfig in ApplicationConfig we need setter method
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}
	
	//combine SPEL and EL
	//for example in hear, the bean id is studentDao
	//                      execute the method getAll()
	//                      dept in here indicate getDept, and you have to execute the compare operator by executing the equals() 
	@Value("#{studentDao.getAll().?[dept.equals('${department}')]}") 
	private Collection<Student> studentsForDepartments = new ArrayList<Student>();

	@Override
	public Collection<Student> getStudentsForDepartments() {
		return studentsForDepartments;
	}

}
