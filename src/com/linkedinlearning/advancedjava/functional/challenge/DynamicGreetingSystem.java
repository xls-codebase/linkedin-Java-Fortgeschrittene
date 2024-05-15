package com.linkedinlearning.advancedjava.functional.challenge;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DynamicGreetingSystem {

    public static void main(String[] args) {
        String userName = "John Doe";

        // Supplier to determine part of the day
        Supplier<String> partOfDaySupplier = () -> {
            int hour = LocalTime.now().getHour();
            if (hour < 12) {
                return "Morning";
            } else if (hour < 18) {
                return "Afternoon";
            }
            else return "Evening";
        };

        // Consumer to display a greeting message
        Consumer<String> greetingConsumer = name -> {
            String partOfDay = partOfDaySupplier.get();
            System.out.println("Good " + partOfDay + ", " + name + "!");
        };

        // Generate and display the greeting message
        greetingConsumer.accept(userName);

    }

}
