package com.Bob_R.service;

import com.Bob_R.model.Product;

public interface StockService {
    boolean checkStockIsAvailable(Product product, int quantity);
}
