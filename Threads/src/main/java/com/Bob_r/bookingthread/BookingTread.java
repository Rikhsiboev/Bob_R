package com.Bob_r.bookingthread;

import java.util.concurrent.locks.Lock;

public class BookingTread implements Runnable {
    int ticketsAvailable = 1;
    private Lock lock;

    public BookingTread(Lock lock) {
        this.lock = lock;
    }

    // Deff between Synchronized block And lock Api
    // Synchronized fully contained within a method

    // Fairness the longest waiting thread is given to access to the lock => should LOCK by time will select
    // lock.lockInterruptibly();  => can be incorporated
    // lock.tryLock();   => 1 Tread will work long time and i dont want wait 2 Tread
    // lock Api

    // Tread Pool




    @Override
    public /*synchronized*/ void run() { //    // this method Thread safety

        // using tryLock means that if the block has been before locking is not available
        // at the time the Traad will no longer wait to see it has been released

        // First thread is doing something
        // Second started waiting -> 20 sec
        // Third started waiting    -> 15 sec
        // Fourth started waiting   -> 10 sec
        System.out.println("Waiting to book the ticker for: " + Thread.currentThread().getName());
        // Lock.lock();
        // lock.tryLock();
        synchronized (this) {  // block safety scope // this method Thread safety
            System.out.println("Waiting to book the ticker for: " + Thread.currentThread().getName());
            if (ticketsAvailable > 0) {
                System.out.println("booking ticked for : " + Thread.currentThread().getName());
                // simulating sometimes to process the payment
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticketsAvailable--;
                System.out.println("Ticket Booked by: " + Thread.currentThread().getName());
                System.out.println("Available tickets: " + ticketsAvailable);
            } else {
                System.out.println("Ticket could`t by: " + Thread.currentThread().getName());
            }
            System.out.println("Booking completed ");
        }
    }

    public void doSomething(Lock lock) throws InterruptedException {
        // let`s pretend from other block we are unlock from here
        lock.unlock();
        lock.lockInterruptibly();
    }

}
