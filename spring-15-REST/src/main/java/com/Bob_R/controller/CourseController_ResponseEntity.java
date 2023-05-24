package com.Bob_R.controller;

import com.Bob_R.dto.CourseDTO;
import com.Bob_R.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api.v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity <List<CourseDTO>> getAllCourse() {
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("Version","Bob_R")
            .header("Operation","Get List")
            .body(courseService.getCourses());
    }
    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseID){
        return ResponseEntity.ok(courseService.getCourseById(courseID));

    }

    @GetMapping("category/{name}")
    public ResponseEntity <List<CourseDTO>> getCategoryByCategory(@PathVariable("name") String category) {
        return ResponseEntity.ok( courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(courseDTO));
    }

}
