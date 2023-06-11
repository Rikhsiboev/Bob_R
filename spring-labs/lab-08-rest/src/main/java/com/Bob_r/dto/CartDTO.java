package com.Bob_r.dto;

import com.Bob_r.enums.CartState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {
    private Long id;
    private CustomerDTO customer;
    private DiscountDTO discount;
    private CartState cartState;
}
