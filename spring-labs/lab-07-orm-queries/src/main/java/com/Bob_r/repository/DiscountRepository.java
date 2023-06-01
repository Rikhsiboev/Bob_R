package com.Bob_r.repository;

import com.Bob_r.entity.Discount;
import com.Bob_r.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
    //Write a derived query to get discount by name
    List<Discount> findAllByName(String name);
    //Write a derived query to get all discounts greater than discount amount
    List<Discount> findAllByDiscountGreaterThanEqual(BigDecimal amount);
    //Write a derived query to get all discounts by specific discount type
    List<Discount> findAllByDiscountType(DiscountType discountType);
    //Write a JPQL query to get all discounts amount between range of discount amount
    @Query("select d from Discount d where d.discount between ?1 and ?2")
    List<Discount> findAllByDiscountBetweenAndDiscountType(BigDecimal startAmount,BigDecimal endAmount);

}
