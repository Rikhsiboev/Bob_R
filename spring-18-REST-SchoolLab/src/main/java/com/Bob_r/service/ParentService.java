package com.Bob_r.service;

import com.Bob_r.dto.ParentDTO;

import java.util.List;

public interface ParentService {

    List<ParentDTO> findAll();

    ParentDTO findById(Long id) throws Exception;

}