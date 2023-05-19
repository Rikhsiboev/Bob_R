package com.Bob_R.repository;


import com.Bob_R.model.Product;
import org.springframework.stereotype.Component;

public class CartRepositoryImpl implements CartRepository{
    public boolean addCartDatabase(Product product, int quantity) {
        System.out.println(product.getName() + " is added to database");
        return true;
    }
}
