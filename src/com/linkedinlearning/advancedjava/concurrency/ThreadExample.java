package com.linkedinlearning.advancedjava.concurrency;

import java.io.IOException;

public class ThreadExample {

    static class BackgroundTimer extends Thread {
        private int seconds;

        public BackgroundTimer(int seconds) {
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = seconds; i > 0; i--) {
                System.out.println("Time left: " + i + " seconds");
                try {
                    Thread.sleep(1000); // Sleep for one second
                } catch (InterruptedException e) {
                    System.out.println("Timer was interrupted.");
                    return;
                }
            }
            System.out.println("Time's up!");
        }
    }

    public static void main(String[] args) throws IOException {
        BackgroundTimer timer = new BackgroundTimer(10); // 10-second timer
        timer.start(); // Start the timer in a background thread

        System.out.println("Timer started. Press Enter to stop early.");
        System.in.read(); // Wait for user to press Enter

        // Optionally, stop the timer early
        if (timer.isAlive()) {
            timer.interrupt();
            System.out.println("Timer stopped early.");
        }
    }

}
