package com.Bob_R;

import com.Bob_R.config.ConfigApp;
import com.Bob_R.model.Product;
import com.Bob_R.repository.CartRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith( SpringRunner.class )
@ContextConfiguration(classes = ConfigApp.class)
public class CartRepositoryTest {

    @Autowired
    private CartRepositoryImpl cartRepository;

    @Test
    public void shouldAddDatabase(){
        Product product = new Product();
        product.setName("milk");
        product.setPrice(new BigDecimal(12));
        product.setQuantity(3);
        product.setRemainingQuantity(3);

        Assert.assertTrue(cartRepository.addCartDatabase(product, 2));
    }

}
