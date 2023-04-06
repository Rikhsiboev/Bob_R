package com.bob_r.Bob_R.entity;


import com.bob_r.Bob_R.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int salary;

}
