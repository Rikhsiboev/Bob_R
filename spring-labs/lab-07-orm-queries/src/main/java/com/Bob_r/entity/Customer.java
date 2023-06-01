package com.Bob_r.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;

    private String userName;
    private String email;

//    @OneToOne(mappedBy = "customer")
//    private Balance customer;

}
