package com.Bob_r.service;

import com.Bob_r.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {

    List<TeacherDTO> findAll();

    TeacherDTO findById(Long id) throws Exception;

}