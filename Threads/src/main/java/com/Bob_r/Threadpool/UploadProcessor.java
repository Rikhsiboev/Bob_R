package com.Bob_r.Threadpool;

public class UploadProcessor implements Runnable{
    private String fileName;

    public UploadProcessor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "has started upload the file: " +fileName );
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + "upload is finished. the file: " +fileName );
    }
}