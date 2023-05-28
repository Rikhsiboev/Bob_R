package com.Bob_r.service;

import com.Bob_r.dto.ClassDTO;

import java.util.List;

public interface ClassService {

    List<ClassDTO> findAll();

    ClassDTO findById(Long id) throws Exception;

}