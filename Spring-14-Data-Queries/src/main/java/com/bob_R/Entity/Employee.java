package com.bob_R.Entity;

import com.bob_R.enums.Gender;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends com.bob_R.entity.BaseEntity {
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
    private com.bob_R.entity.Region region;


}
