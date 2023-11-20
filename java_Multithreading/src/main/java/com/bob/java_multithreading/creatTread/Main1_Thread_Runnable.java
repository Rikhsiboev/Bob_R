package com.bob.java_multithreading.creatTread;

public class Main1_Thread_Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
               // CODE that will run un a new thread
                System.out.println("we are inside thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional Exception");
            }

        }) {
        };
        thread.setName(" New Worker thread ");
        thread.setPriority(thread.MAX_PRIORITY);
        System.out.println("we are in thread: " + Thread.currentThread().getName()+ " before start a new thread");
        thread.start();
        System.out.println("we are in thread: " + Thread.currentThread().getName()+ " after start a new thread");
        Thread.sleep(10000);

        // thread with exception and message
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread "+ t.getName()
                + " the error is" + e.getMessage());
            }
        });




    }
}
