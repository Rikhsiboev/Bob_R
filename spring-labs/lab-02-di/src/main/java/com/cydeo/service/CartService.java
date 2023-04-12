package com.Bob_R.service;

import com.Bob_R.model.Cart;
import com.Bob_R.model.Product;

public interface CartService {
    Cart addCart(Product product, int quantity);
}
