package com.linkedinlearning.advancedjava.concurrency;

public class SynchronizedAccess {

    static class SharedCounter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public void decrement() {
            count--;
        }

        public int getCount() {
            return count;
        }

    }

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedCounter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedCounter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Finished executing both threads.");
        System.out.println("Final count: " + sharedCounter.getCount());
    }

}
