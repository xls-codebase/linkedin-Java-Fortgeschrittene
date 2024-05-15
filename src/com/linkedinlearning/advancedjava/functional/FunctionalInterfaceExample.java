package com.linkedinlearning.advancedjava.functional;

import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaceExample {

    @FunctionalInterface
    public interface StringTransform {
        String apply(String input);
    }

    public static void main(String[] args) {
        // List of strings to transform
        List<String> strings = Arrays.asList("hello", "world", "java", "streams");

        // Lambda expression for converting a string to uppercase
        StringTransform appendFoo = input -> input + "foo";

        // Using a stream to apply the transformation to all strings in the list
        List<String> transformedStrings = strings.stream()
                .map(appendFoo::apply)
                .toList();

        // Print the original and transformed lists
        System.out.println("Original strings: " + strings);
        System.out.println("Transformed strings: " + transformedStrings);
    }

}
