package com.Bob_r.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Balance extends BaseEntity {

    private BigDecimal amount;

//    @OneToOne(fetch = FetchType.LAZY) // it will not load
//    @OneToOne(fetch = FetchType.EAGER) // will bring that object too
   @OneToOne
    public Customer customer;


}
