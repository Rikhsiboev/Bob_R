package com.Bob_r.service.impl;

import com.Bob_r.dto.CourseDTO;
import com.Bob_r.entity.Course;
import com.Bob_r.util.MapperUtil;
import com.Bob_r.repository.CourseRepository;
import com.Bob_r.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> mapperUtil.convert(course,new CourseDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Long id) throws Exception {
        Course foundCourse = courseRepository.findById(id)
                .orElseThrow(() -> new Exception("No Course Found!"));
        return mapperUtil.convert(foundCourse, new CourseDTO());
    }

}