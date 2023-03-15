package com.pizza.dto.adress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
@AllArgsConstructor
public class Address {
    private String FullName;
    private String street;
    private String city;
    private String state;
    private int zip;


}
