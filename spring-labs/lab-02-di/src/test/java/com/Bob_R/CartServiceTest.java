package com.Bob_R;

import com.Bob_R.config.ConfigApp;
import com.Bob_R.model.Cart;
import com.Bob_R.model.Product;
import com.Bob_R.repository.CartRepository;
import com.Bob_R.service.CartServiceImpl;
import com.Bob_R.service.StockService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith( SpringRunner.class )
@ContextConfiguration(classes = ConfigApp.class)
public class CartServiceTest {

    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private StockService stockService;


    @Test
    public void addCartTest(){
        Product product = new Product();
        product.setName("milk");
        product.setPrice(new BigDecimal(12));
        product.setQuantity(3);
        product.setRemainingQuantity(3);
        Cart cart = cartService.addCart(product, 2);
        Assert.assertEquals(new BigDecimal(24), cart.getCartTotalAmount());
    }
}
