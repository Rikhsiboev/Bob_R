package com.Bob_R.review;

public class Product {

    public String name;
    public Unit unitOfMeasurement;
    public String quantity;

    public Product(String name, Unit unitOfMeasurement, String quantity) {
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.quantity = quantity;
    }

}
