package com.Bob_R.spring05thymeleaf.service;


import com.Bob_R.spring05thymeleaf.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    boolean productCreate(Product product);
    List<Product> listProduct();
    Product findProductById(UUID uuid);
}
