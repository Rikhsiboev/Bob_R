package com.Bob_R.solid.dependencyInversion.example.good;

public class MyApp {

    public static void read(Reader reader) {

        UserReader userReader = new UserReader(reader);

        userReader.getUsername();

    }

}
