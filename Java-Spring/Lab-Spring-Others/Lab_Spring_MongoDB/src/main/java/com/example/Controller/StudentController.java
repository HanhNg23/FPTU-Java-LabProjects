package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Student APIs")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students")
    public List<Student> fetchAllStudents(){
	return studentService.getAllSrudents();
    }
    
    @PostMapping("/new")
    public void addNewStudent(@RequestBody Student student) {
	studentService.createNewStudents(student);
    }

}
