package com.Bob_r.counter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterThread counterThread = new CounterThread(counter);
        CounterThread copy= new CounterThread(counter);
        copy.start();
        copy.join();
        counterThread.start();
        counterThread.join();
        System.out.println(counter.c);
    }
}
