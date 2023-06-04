package com.Bob_rr.dto;

import com.Bob_rr.enums.DiscountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DiscountDTO{
    private String name;
    private BigDecimal discount;
    private DiscountType discountType;
    private Long id;
}
