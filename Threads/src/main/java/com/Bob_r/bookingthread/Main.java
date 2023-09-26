package com.Bob_r.bookingthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        Runnable runnable = new BookingTread(lock);
        Thread sam = new Thread(runnable, "Sam");
        Thread Ozzy = new Thread(runnable, "Ozzy");
        sam.start();
        Ozzy.start();
        
        
        
    }
}
