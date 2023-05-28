package com.Bob_r.service;

import com.Bob_r.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    List<CourseDTO> findAll();

    CourseDTO findById(Long id) throws Exception;

}