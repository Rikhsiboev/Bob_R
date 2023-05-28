package com.Bob_r.controller;

import com.Bob_r.dto.AddressDTO;
import com.Bob_r.dto.ResponseWrapper;
import com.Bob_r.dto.TeacherDTO;
import com.Bob_r.service.AddressService;
import com.Bob_r.service.ParentService;
import com.Bob_r.service.StudentService;
import com.Bob_r.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.addressService = addressService;
    }
    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeacher() {
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved", studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(true,"Students are successfully retrieved"
                ,HttpStatus.ACCEPTED.value(),parentService.findAll());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent","Returned")
                .body(responseWrapper);

    }


    @GetMapping("address/{id}")
    public ResponseEntity<ResponseWrapper> findById(@PathVariable("id") Long addressFindById) throws Exception {
        // find the addrtess to return
//        AddressDTO addressDTO = addressService.findById(addressFindById);


        return ResponseEntity
                .ok(new ResponseWrapper
                        ("Students are successfully retrieved",
                                addressService.findById(addressFindById)));

    }


}
