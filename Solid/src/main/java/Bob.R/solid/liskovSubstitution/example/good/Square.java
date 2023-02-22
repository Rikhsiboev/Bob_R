package com.Bob_R1.solid.liskovSubstitution.example.good;

public class Square implements Shape {

    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }

}
