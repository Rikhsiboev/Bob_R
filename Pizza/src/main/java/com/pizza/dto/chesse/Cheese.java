package com.pizza.dto.chesse;

import com.pizza.Enum.QuantityEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


@NoArgsConstructor
@Data
@Component
@AllArgsConstructor

public abstract class Cheese  {
    private QuantityEnum quantityEnum;
    private int id;


}
