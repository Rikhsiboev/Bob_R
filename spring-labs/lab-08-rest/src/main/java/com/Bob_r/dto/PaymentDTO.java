package com.Bob_r.dto;

import com.Bob_r.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO {
    private Long id;
    private BigDecimal paidPrice;
    private PaymentMethod paymentMethod;
}
