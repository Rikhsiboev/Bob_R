package com.Bob_R.java10;

import java.util.Arrays;

public class LocalVariableTypeDemo {
    public static void main(String[] args) {

        String s ;
        s = "Ozzy";

        var str = "Bob_R";

        var number = 5;

        byte x = 1;
        var y = 1; //int

        var price = 12.50;

        var numbers = Arrays.asList(3,4,5,6);

        var sum = 0;
        for(var eachNumber : numbers){
            sum = sum+eachNumber;
        }







    }
}
