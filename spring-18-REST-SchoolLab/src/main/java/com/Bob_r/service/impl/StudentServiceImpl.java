package com.Bob_r.service.impl;

import com.Bob_r.dto.StudentDTO;
import com.Bob_r.entity.Student;
import com.Bob_r.util.MapperUtil;
import com.Bob_r.repository.StudentRepository;
import com.Bob_r.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final MapperUtil mapperUtil;

    public StudentServiceImpl(StudentRepository studentRepository, MapperUtil mapperUtil) {
        this.studentRepository = studentRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> mapperUtil.convert(student, new StudentDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) throws Exception {
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(() -> new Exception("No Student Found!"));
        return mapperUtil.convert(foundStudent, new StudentDTO());
    }

}