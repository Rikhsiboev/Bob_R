package com.Bob_r.dto;

import com.Bob_r.enums.EducationLevel;
import com.Bob_r.enums.Status;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  // skips unknown filds
public class TeacherDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String email;
    private String username;
    @J
    private String password;

    private LocalDate birthday;

    private Status status;

    private EducationLevel educationLevel;
   @JsonBackReference(value = "teacher-address-reference")
    private AddressDTO address;

}