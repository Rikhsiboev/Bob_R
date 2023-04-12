package com.Bob_R.repository;

import com.Bob_R.model.Product;


public interface CartRepository {
    boolean addCartDatabase(Product product, int quantity);
}
