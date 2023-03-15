package com.pizza.service.serviceImp.serviceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonAbstractImp <T,Type> {
    public Map<Type,T> map = new HashMap<>(); // this is my DB

    T save(Type Type ,T object){
        map.put(Type,object);
        return object;
    }

    List<T> findAll(){
        return new ArrayList<>(map.values());
    }

    T findByID(Type Type){
        return map.get(Type);
    }
    void deleteById(Type Type){
        map.remove(Type);
    }
}
