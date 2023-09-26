package com.Bob_r.Deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable {
    private Lock ozzy;
    private Lock sam;

    public Runnable1(Lock ozzy, Lock sam) {
        this.ozzy = ozzy;
        this.sam = sam;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " Acquiring Ozzy");
        ozzy.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName + " is trying to acquire Sam");
        sam.lock();
        System.out.println(threadName + " Sam acquired");

        System.out.println(threadName + "Release Ozzy");
        ozzy.unlock();
        System.out.println(threadName + "Release Sam");
        sam.unlock();
    }
}