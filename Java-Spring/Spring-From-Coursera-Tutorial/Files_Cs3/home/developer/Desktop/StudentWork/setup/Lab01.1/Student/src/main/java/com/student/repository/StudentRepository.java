package com.student.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.student.core.Student;

@RepositoryRestResource(collectionResourceRel = "student", path = "enrollments", excerptProjection = Person.class)

public interface StudentRepository extends JpaRepository<Student, Long>{
 
	//anytime url containt enrollments --> return only specific properties which is defined in Person class
	Collection<Student> findByDept(String dept);
	
	@Query("SELECT student FROM Student student WHERE student.dept = :dept")
	Collection<Student> getByDept(@Param("dept") String dept);
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	Student save(Student entity);
	
}
