package com.Bob_r.controller;

import com.Bob_r.dto.AddressDTO;
import com.Bob_r.dto.ResponseCodeWrapper;
import com.Bob_r.dto.TeacherDTO;
import com.Bob_r.service.AddressService;
import com.Bob_r.service.ParentService;
import com.Bob_r.service.StudentService;
import com.Bob_r.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseCodeWrapper> readAllStudents() {
        return ResponseEntity.ok(new ResponseCodeWrapper("Students are successfully retrieved", studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseCodeWrapper> readAllParents() {
        ResponseCodeWrapper responseWrapper = new ResponseCodeWrapper(true,"Students are successfully retrieved"
                ,HttpStatus.ACCEPTED.value(),parentService.findAll());
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Parent","Returned")
                .body(responseWrapper);

    }


    @GetMapping("address/{id}")
    public ResponseEntity<ResponseCodeWrapper> findById(@PathVariable("id") Long addressFindById) throws Exception {
        // find the addrtess to return
//        AddressDTO addressDTO = addressService.findById(addressFindById);

        AddressDTO addressToReturn = addressService.findById(addressFindById);
//        return ResponseEntity
//                .ok(new ResponseCodeWrapper
//                        ("Students are successfully retrieved",
//                                addressService.findById(addressFindById)));

        return ResponseEntity.ok(
                new ResponseCodeWrapper("Address "+addressFindById+" is successfully retrieved",addressToReturn));
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception {
       addressDTO.setId(id);
        AddressDTO update = addressService.update(addressDTO);
        return update;
    }

}
