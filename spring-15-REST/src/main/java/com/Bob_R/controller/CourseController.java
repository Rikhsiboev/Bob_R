package com.Bob_R.controller;

import com.Bob_R.dto.CourseDTO;
import com.Bob_R.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller +@RequestBody
@RequestMapping("/courses/api.v1")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //@RequestBody
    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCategoryByCategory(@PathVariable("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping()
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseID, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseID, course);
    }
    @DeleteMapping("{id} ")
    public void deleteCourseById(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
    }

}
