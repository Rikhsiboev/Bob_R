package com.Bob_R.service;

import com.Bob_R.model.Cart;
import com.Bob_R.model.Product;
import com.Bob_R.repository.CartRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class CartServiceImpl implements CartService{
    private CartRepository cartRepository;
    private StockService service;

    public Cart addCart(Product product, int quantity) {
        boolean stockAvailable = service.checkStockIsAvailable(product, quantity);
        Cart cart = new Cart();
        if (!stockAvailable){
           return cart;
        }
        cartRepository.addCartDatabase(product, quantity);
        BigDecimal totalAmount = product.getPrice().multiply(new BigDecimal(quantity));
        Map<Product, Integer> productMap = new HashMap<>();
        productMap.put(product, quantity);
        cart.setCartTotalAmount(totalAmount);
        cart.setProductMap(productMap);
        return cart;

    }
}
