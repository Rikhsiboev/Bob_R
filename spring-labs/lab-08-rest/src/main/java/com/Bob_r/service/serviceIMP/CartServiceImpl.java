package com.Bob_r.service.serviceIMP;

import com.Bob_r.repository.CartRepository;
import com.Bob_r.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public boolean existById(Long paymentId) {
        return cartRepository.existsById(paymentId);
    }
}
