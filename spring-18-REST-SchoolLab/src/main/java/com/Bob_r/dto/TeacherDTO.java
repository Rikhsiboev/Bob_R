package com.Bob_r.dto;

import com.Bob_r.enums.EducationLevel;
import com.Bob_r.enums.Status;
import com.fasterxml.jackson.annotation.*;
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
@JsonInclude(JsonInclude.Include.NON_NULL)  // i dont wont to see in jsan but dynamic
public class TeacherDTO {
    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String email;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //we are not returning password
    private String password;

    private LocalDate birthday;

    private Status status;

    private EducationLevel educationLevel;
    @JsonBackReference(value = "teacher-address-reference")
    private AddressDTO address;

}