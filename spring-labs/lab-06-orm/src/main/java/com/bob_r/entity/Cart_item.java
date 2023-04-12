package com.bob_r.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cart_item extends BaseEntity {
    private Integer quantity;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;


}
