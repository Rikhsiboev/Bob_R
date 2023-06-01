package com.Bob_r.entity;

import com.Bob_r.enums.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Discount extends BaseEntity{
    private String name;
    private BigDecimal discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
}
