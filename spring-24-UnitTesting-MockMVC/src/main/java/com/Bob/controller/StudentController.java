package com.Bob.controller;

import com.Bob.dto.StudentDTO;
import com.Bob.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public StudentDTO getStudent() {
        return new StudentDTO("Mike", "Smith", 20);
    }

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
        // new StudentDTO("John", "Doe", 20),
        // new StudentDTO("Tom", "Hanks", 50)
    }

}
