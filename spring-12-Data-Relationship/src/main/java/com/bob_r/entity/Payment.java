package com.bob_r.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;
    @OneToOne
    @JoinColumn(name = "Bob")
    private PaymentDetails paymentDetails;

    public Payment(LocalDate date, BigDecimal amount, Status paymentStatus) {
        this.date = date;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
