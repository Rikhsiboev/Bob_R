package com.Bob_R.model;

import com.Bob_R.enums.Cheese;
import com.Bob_R.enums.Sauce;
import com.Bob_R.enums.Topping;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Pizza {

    private UUID id;
    private List<Cheese> cheeseList;
    private List<Sauce> sauceList;
    private List<Topping> toppingList;

}
