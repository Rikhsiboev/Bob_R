package com.Bob_r.entity;

import com.Bob_r.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payment extends BaseEntity {
    private BigDecimal paidPrice;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
