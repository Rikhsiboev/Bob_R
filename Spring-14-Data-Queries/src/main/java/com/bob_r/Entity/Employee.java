package com.bob_r.Entity;

import com.bob_r.enums.Gender;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
