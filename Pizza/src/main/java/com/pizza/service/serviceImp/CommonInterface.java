package com.pizza.service.serviceImp;

import com.pizza.Enum.QuantityEnum;

import java.util.List;

public interface CommonInterface<T,Quantity> {
    T save(T type);
    T findByType(Quantity typename);
    List<T> findAll();
    void deleteType(Quantity typename);
}
