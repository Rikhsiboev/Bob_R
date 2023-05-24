package com.Bob_R.controller;

import com.Bob_R.dto.CourseDTO;
import com.Bob_R.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller +@RequestBody
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@RequestBody
    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }


}
