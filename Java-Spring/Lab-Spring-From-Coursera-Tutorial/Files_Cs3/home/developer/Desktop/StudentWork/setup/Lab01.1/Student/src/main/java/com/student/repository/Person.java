package com.student.repository;

import org.springframework.data.rest.core.config.Projection;

import com.student.core.Student;

@Projection(name = "person", types = Student.class)
//projection is used to get a part of representation of an Entity class
public interface Person {
	String getFirstName();
	String getSurname(); //the method name must be math with the get Attribute in Student.class
	String getId();
	//in this interface we define that if url contain projection which value is person
	//--> then return only these values firstname, surename, id
}
