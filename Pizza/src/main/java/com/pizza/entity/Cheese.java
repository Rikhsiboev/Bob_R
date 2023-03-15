package com.pizza.entity;

import java.time.LocalDateTime;

public class Cheese extends BaseEntity{
    private String mozzarella;
    private String cheddar;
    private String parmesan;

    public Cheese(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserid, String mozzarella, String cheddar, String parmesan) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserid);
        this.mozzarella = mozzarella;
        this.cheddar = cheddar;
        this.parmesan = parmesan;
    }
}
