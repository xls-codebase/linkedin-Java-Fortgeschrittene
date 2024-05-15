package com.linkedinlearning.advancedjava.concurrency;

public class ConcurrencyIntro {

    static class NumberPrinter implements Runnable {
        private String threadName;

        public NumberPrinter(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                System.out.println(threadName + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));

        thread1.start(); // Start the first thread
        thread2.start(); // Start the second thread

        try {
            thread1.join(); // Wait for thread 1 to finish
            thread2.join(); // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Finished executing both threads.");
    }


}
