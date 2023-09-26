package com.Bob_r.Threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadProcesor implements Runnable{
    private String fileName;

    public DownloadProcesor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"has started Download");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"Downloand is finished ");





    }
}
