package com.Bob_R1.solid.interfaceSegregation.example.good;

public class Chicken implements CanEat, CanWalk {

    @Override
    public void eat() {
        System.out.println("Eating");
    }

    @Override
    public void walk() {
        System.out.println("Walking");
    }

}
