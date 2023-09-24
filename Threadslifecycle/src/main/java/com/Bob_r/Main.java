package com.Bob_r;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getState());
        System.out.println("hello world");
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        Thread.sleep(1000L);

        System.out.println("--------------------------------");
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        System.out.println("---------------sleep 1 sec -----------------");
        Thread.sleep(1000L);
        System.out.println(myThread.getState());
        System.out.println("--------------------------------");
        MyRunnable myRunnable1 = new MyRunnable();
        Thread myRunnableThread = new Thread(myRunnable1);
        myRunnableThread.start();




    }
}
