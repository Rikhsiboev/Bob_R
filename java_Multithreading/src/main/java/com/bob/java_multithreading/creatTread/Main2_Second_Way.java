package com.bob.java_multithreading.creatTread;

public class Main2_Second_Way {
    public static void main(String[] args) {
        Thread thread = new NewTread();
        thread.start();
    }


    private static class NewTread extends Thread{
        // Code that Executes on the new thread

        @Override
        public void run() {
            System.out.println(" Hello form " + this.getName());
        }
    }
}
