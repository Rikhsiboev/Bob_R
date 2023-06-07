package com.Bob_r.service;

import com.Bob_r.dto.ProductDTO;
import com.Bob_r.dto.ProductRequest;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductDTO> retrieveProductList();
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> retrieveAllProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price);}
