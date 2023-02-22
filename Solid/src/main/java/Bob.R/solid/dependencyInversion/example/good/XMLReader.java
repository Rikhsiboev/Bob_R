package com.Bob_R1.solid.dependencyInversion.example.good;

public class XMLReader implements Reader {

    @Override
    public String getUsername() {
        return "<username>mikesmith</username>";
    }

}
