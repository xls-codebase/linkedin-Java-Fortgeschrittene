package com.linkedinlearning.advancedjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {

    static class DownloadTask implements Runnable {
        private String fileName;
        private int fileSize;

        public DownloadTask(String fileName, int fileSize) {
            this.fileName = fileName;
            this.fileSize = fileSize; // Simulated file size in MB
        }

        @Override
        public void run() {
            int downloaded = 0;
            System.out.println("Starting download: " + fileName);

            while (downloaded < fileSize) {
                System.out.println("Downloaded " + downloaded + " MB / " + fileSize + " MB");
                downloaded += 10; // Simulate downloading 10 MB
                try {
                    Thread.sleep(1000); // Simulate time taken to download 10 MB
                } catch (InterruptedException e) {
                    System.out.println("Download interrupted: " + fileName);
                    return;
                }
            }

            System.out.println("Download complete: " + fileName);
        }
    }

    public static void main(String[] args) {
        // Create the download task
        DownloadTask task = new DownloadTask("example.zip", 50); // 50 MB file

        Runnable counterRunnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Counter: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Counter interrupted.");
                }
            }
        };

        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2); // Adjust the pool size as needed

        // Submit the download task for execution
        executor.submit(task);
        executor.submit(counterRunnable);

        // Optionally, submit more tasks here

        // Shutdown the executor once all tasks are complete
        executor.shutdown(); // Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
    }


}
