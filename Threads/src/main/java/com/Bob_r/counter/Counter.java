package com.Bob_r.counter;

public class Counter {
    int c= 0;

    public synchronized void increment(){
        c++;
    }
}
