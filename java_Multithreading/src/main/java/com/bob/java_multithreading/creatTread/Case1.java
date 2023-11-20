package com.bob.java_multithreading.creatTread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Case1 {
    // 3 time add password after 3 time police will arrest them as thread
    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());
        threadList.forEach(Thread::start);
    }

    public static final int MAX_PASSWORD = 9999;

    private static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guest) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            return this.password == guest;
        }
    }

    private static abstract class HackedThread extends Thread {
        protected Vault vault;

        public HackedThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting Thread in side Hacked Tread" + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackedThread {


        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guess = 0; guess < MAX_PASSWORD; guess++) {
                if (vault.isCorrectPassword(guess)) {
                    System.out.println(this.getName() + " guessed the password as Ascending" + guess);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackedThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int guesss = MAX_PASSWORD; guesss > 0; guesss--) {
                if (vault.isCorrectPassword(guesss)) {
                    System.out.println(this.getName() + " guessed the password  from desc" + guesss);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("Game Over for you hacker");
            System.exit(0);
        }
    }
}
