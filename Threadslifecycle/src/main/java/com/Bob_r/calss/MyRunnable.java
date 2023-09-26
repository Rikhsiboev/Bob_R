package com.Bob_r.calss;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("My Thread Runnable");
    }
}
