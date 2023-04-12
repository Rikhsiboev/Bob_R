
package com.Bob_R.lab04springmvc.service;

import com.Bob_R.lab04springmvc.model.Cart;
import com.Bob_R.lab04springmvc.model.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<Cart> retrieveCartList();

    List<CartItem> retrieveCartDetail(UUID cartId);

    void initialiseCartList();
}
