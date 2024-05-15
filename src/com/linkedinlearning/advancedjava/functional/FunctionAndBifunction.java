package com.linkedinlearning.advancedjava.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBifunction {

    public static void main(String[] args) {
        // Function to square a number
        Function<Integer, Integer> square = x -> x * x;

        // Apply the function
        int result = square.apply(5);
        System.out.println("Square of 5: " + result);

        // BiFunction to add two numbers and convert to string
        BiFunction<Integer, Integer, String> addAndToString = (x, y) -> Integer.toString(x + y);

        // Apply the BiFunction
        String sum = addAndToString.apply(5, 3);
        System.out.println("Sum of 5 and 3: " + sum);
    }

}
