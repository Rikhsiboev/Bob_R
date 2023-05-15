package com.Bob_R.spring05thymeleaf.service;


import com.Bob_R.spring05thymeleaf.model.Cart;

import java.util.UUID;

public interface CartService {
    Cart addToCart(UUID productId, Integer quantity);
    boolean deleteFromCart(UUID productId);
}
