package com.cydeo.review;

import java.util.Arrays;

public class EnumTest {

    public static void main(String[] args) {

        User employee = new User("mikesmith", "Mike", "Smith", Role.EMPLOYEE);

        System.out.println(employee);

        System.out.println(Unit.POUNDS.value);
        System.out.println(Arrays.toString(Unit.values()));

    }

}
