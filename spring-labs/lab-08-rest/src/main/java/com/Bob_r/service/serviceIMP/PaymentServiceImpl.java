package com.Bob_r.service.serviceIMP;

import com.Bob_r.repository.PaymentRepository;
import com.Bob_r.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public boolean existById(Long paymentId) {
        return paymentRepository.existsById(paymentId);
    }
}