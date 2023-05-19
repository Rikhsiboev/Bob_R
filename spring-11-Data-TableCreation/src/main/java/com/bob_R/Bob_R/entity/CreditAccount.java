package com.bob_R.Bob_R.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CreditAccount extends Account {

    private BigDecimal creditLimit;
}
