package com.Bob_R1.solid.dependencyInversion.example.good;

public class TextReader implements Reader {

    @Override
    public String getUsername() {
        return "mikesmith";
    }

}
