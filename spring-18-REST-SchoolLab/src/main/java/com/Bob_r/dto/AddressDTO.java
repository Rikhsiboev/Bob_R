package com.Bob_r.dto;

import com.Bob_r.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  // skips unknown filds
@JsonInclude(JsonInclude.Include.NON_NULL)  //
public class AddressDTO {
    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String flag;

    private AddressType addressType;
    @JsonBackReference(value = "Student-address-reference")
    private StudentDTO student;
    @JsonBackReference(value = "parent-address-reference")
    private ParentDTO parent;
    @JsonBackReference(value = "teacher-address-reference")
    private TeacherDTO teacher;

    private Integer currentTemperature;


}