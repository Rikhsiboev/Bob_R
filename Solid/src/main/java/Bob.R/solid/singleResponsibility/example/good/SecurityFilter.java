package com.Bob_R1.solid.singleResponsibility.example.good;

public class SecurityFilter {

    public static boolean authenticate() {
        // Check authentication
        return true;
    }

    public static boolean authorization() {
        // Check authorization
        return true;
    }

}
