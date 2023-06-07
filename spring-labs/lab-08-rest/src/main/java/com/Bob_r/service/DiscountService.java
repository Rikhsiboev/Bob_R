package com.Bob_r.service;

import com.Bob_r.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<DiscountDTO> findAllDiscounts();

    void updateDiscount(DiscountDTO discountDTO);

    DiscountDTO createDiscount(DiscountDTO discountDTO);

    DiscountDTO getDiscountByName(String name);
}
