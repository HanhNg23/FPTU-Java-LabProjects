package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public interface StudentRepository 
extends MongoRepository<Student, Integer>{

    Optional<Student> findStudentByEmail(String email);
    
}
