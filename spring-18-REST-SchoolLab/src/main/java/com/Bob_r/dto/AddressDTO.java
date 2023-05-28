package com.Bob_r.dto;

import com.Bob_r.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;
    @JsonBackReference(value = "Student-address-reference")
    private StudentDTO student;
    @JsonBackReference(value = "parent-address-reference")
    private ParentDTO parent;
    @JsonBackReference(value = "teacher-address-reference")
    private TeacherDTO teacher;

    private Integer currentTemperature;

}