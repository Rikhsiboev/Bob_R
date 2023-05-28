package com.Bob_r.dto;

import com.Bob_r.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private String profession;
    private String phoneNumber;

    private String email;
    private String username;
    private String password;

    private LocalDate birthday;

    private Status status;
//    @JsonBackReference(value = "parent-address-reference")
    private AddressDTO address;

}
