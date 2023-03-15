package com.pizza.service.serviceImp.serviceImp;

import com.pizza.dto.chesse.Cheese;
import com.pizza.service.serviceImp.CheeseInterface;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheeseImp extends CommonAbstractImp<Cheese,String> implements CheeseInterface {
    @Override
    public Object save(Object type) {
        return null;
    }

    @Override
    public Object findByType(Object typename) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void deleteType(Object typename) {

    }
}
