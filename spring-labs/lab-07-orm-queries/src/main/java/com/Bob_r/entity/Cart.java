package com.Bob_r.entity;

import com.Bob_r.enums.CartState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Cart extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private  Discount discount;
    @ManyToOne
    private Customer customer;

}
