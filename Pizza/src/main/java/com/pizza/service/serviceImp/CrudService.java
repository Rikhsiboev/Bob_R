package com.pizza.service.serviceImp;

import java.util.List;

public interface CrudService<T,Quantity> {
    T save(T type);
    T findByType(Quantity typename);
    List<T> findAll();
    void deleteType(Quantity typename);
}
