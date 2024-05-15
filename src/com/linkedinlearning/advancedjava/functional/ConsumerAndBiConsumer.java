package com.linkedinlearning.advancedjava.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerAndBiConsumer {

    public static void main(String[] args) {
        // Consumer to print a custom message
        Consumer<String> messagePrinter = message -> System.out.println("Message: " + message);

        // Apply the Consumer
        messagePrinter.accept("Hello, World!");

        // BiConsumer to concatenate and print two strings
        BiConsumer<String, String> combiningMessagePrinter = (str1, str2) -> System.out.println(str1 + " " + str2);

        // Apply the BiConsumer
        combiningMessagePrinter.accept("Hello", "World!");
    }

}
