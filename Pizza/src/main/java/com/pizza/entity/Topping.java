package com.pizza.entity;

import java.time.LocalDateTime;

public class Topping extends BaseEntity{
    private String Mushroom;
    private String Jalapenos;
    private String RedPeppers;
    private String tomatoes;

    public Topping(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserid, String mushroom, String jalapenos, String redPeppers, String tomatoes) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserid);
        Mushroom = mushroom;
        Jalapenos = jalapenos;
        RedPeppers = redPeppers;
        this.tomatoes = tomatoes;
    }
}
