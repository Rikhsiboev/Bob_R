package com.Bob_R.controller;

import com.Bob_R.dto.CourseDTO;
import com.Bob_R.dto.ResponseWrapper;
import com.Bob_R.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses/api.v3")
public class CourseController_ResponseWrapper {
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourse(){
    return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("Version","Bob_R_V3")
            .body( new ResponseWrapper("courses successfully retrieved",courseService.getCourses()));

    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity.ok()
                .body(new ResponseWrapper(" course "+courseId+" retrieved ",courseService.getCourseById(courseId)));

    }


}
