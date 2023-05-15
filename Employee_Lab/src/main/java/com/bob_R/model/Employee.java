package com.bob_R.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
//    @NotNull    //-> field shouldn`t be null
//    @NotEmpty   //-> "" field shouldn`t empty
//    @NotBlank   //-> " " field shouldn`t Blank

    @NotBlank  //-> cover all
    @Size(max = 12, min = 2)
    private String firstName;
    private String lastName;
    //thymeleaf accept yyyy-mm-dd this format but LocalDate accepts mm-dd-yyyy
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
//    @NotBlank
//    @Email
    private String email;

//    @NotBlank
//    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
}
