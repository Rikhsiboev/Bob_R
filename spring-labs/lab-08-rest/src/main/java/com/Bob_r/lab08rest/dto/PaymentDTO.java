package com.Bob_r.lab08rest.dto;

import com.Bob_r.lab08rest.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDTO {
    private BigDecimal paidPrice;
    private PaymentMethod paymentMethod;
}
