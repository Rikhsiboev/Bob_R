package com.bob_r.entity;

import com.bob_r.enums.CartState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Cart extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private  Discount discount;
    @ManyToOne
    private Customer customer;

}
