package com.Bob.service.impl;

import com.Bob.dto.StudentDTO;
import com.Bob.repository.StudentRepository;
import com.Bob.service.StudentService;
import com.Bob.util.MapperUtil;
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

    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream().map(student -> mapperUtil.convert(student, new StudentDTO())).collect(Collectors.toList());
    }

}
