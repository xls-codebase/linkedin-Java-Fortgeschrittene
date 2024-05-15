package com.linkedinlearning.advancedjava.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CurrencyFriendlyTypes {
    static public class AccessCounter {
        private Map<String, Integer> userAccessCounts = new ConcurrentHashMap<>();

        public void incrementAccessCount(String userId) {
            userAccessCounts.compute(userId, (key, val) -> (val == null) ? 1 : val + 1);
            userAccessCounts.compute("total", (key, val) -> (val == null) ? 1 : val + 1);
        }

        public void printAccessCounts() {
            userAccessCounts.forEach((userId, count) -> System.out.println("User " + userId + " accessed " + count + " times."));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AccessCounter accessCounter = new AccessCounter();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Simulate 1000 accesses for User 1 and User 2
        for (int i = 0; i < 1000; i++) {
            String userId1 = "User1";
            executor.submit(() -> accessCounter.incrementAccessCount(userId1));

            String userId2 = "User2";
            executor.submit(() -> accessCounter.incrementAccessCount(userId2));
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        // Print the final access counts
        accessCounter.printAccessCounts();
    }

}
