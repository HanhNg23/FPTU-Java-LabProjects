package com.student.service;

import java.util.Collection;
import java.util.Optional;

import com.student.core.Student;

public interface StudentService {
	
	Student get(long id);
	Collection<Student> getAllStudents();
	Collection<Student> getStudentsByDepartment(String department);
	Student get_new_verse(Long id);
	
}
