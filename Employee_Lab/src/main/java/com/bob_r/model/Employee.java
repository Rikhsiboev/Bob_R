package com.bob_r.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
//    @NotNull    //-> field shouldn`t be null
//    @NotEmpty   //-> "" field shouldn`t empty
//    @NotBlank   //-> " " field shouldn`t Blank

    @NotBlank  //-> cover all
    @Size(max = 12 , min = 2)
    private String firstName;
    private String lastName;
    //thymeleaf accept yyyy-mm-dd this format but LocalDate accepts mm-dd-yyyy
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
