package com.linkedinlearning.advancedjava.functional;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample {

    public static void main(String[] args) {
        // Supplier of random numbers
        Supplier<Integer> randomNumbersSupplier = () -> new Random().nextInt(100); // Random numbers between 0 and 99

        // Generate a stream of 10 random numbers using the supplier
        List<Integer> randomNumbers = Stream.generate(randomNumbersSupplier)
                .limit(10)
                .toList();

        System.out.println("Random numbers: " + randomNumbers);
    }

}
