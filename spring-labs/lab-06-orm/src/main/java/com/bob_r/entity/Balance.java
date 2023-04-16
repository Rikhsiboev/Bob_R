package com.bob_r.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Balance extends BaseEntity {

    private BigDecimal amount;

//    @OneToOne(fetch = FetchType.LAZY) // it will not load
//    @OneToOne(fetch = FetchType.EAGER) // will bring that object too
   @OneToOne
    public Customer customer;


}
