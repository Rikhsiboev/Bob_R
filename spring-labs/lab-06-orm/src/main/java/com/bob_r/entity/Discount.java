package com.bob_r.entity;

import com.bob_r.enums.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Discount extends BaseEntity{
    private String name;
    private BigDecimal discount;
    @Enumerated
    private DiscountType discountType;
}
