package com.pizza.entity;

import java.time.LocalDateTime;

public class Sauce extends BaseEntity {
    private String tomatoSauce;
    private String RedSauce;
    private String SweetPizzaSauce;

    public Sauce(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserid, String tomatoSauce, String redSauce, String sweetPizzaSauce) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserid);
        this.tomatoSauce = tomatoSauce;
        RedSauce = redSauce;
        SweetPizzaSauce = sweetPizzaSauce;
    }
}
