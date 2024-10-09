package com.linkedinlearning.advancedjava.functional.challenge;

import java.time.LocalTime;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DynamicGreetingSystemMySolution {

    public static void main(String[] args) {

        Supplier<String> getDayTime = () -> {
            enum DayTime { MORNING, AFTERNOON, EVENING }
            int actualTimeHour = LocalTime.now().getHour();

            if (12 > actualTimeHour) {
                return DayTime.MORNING.toString().toLowerCase();
            }
            if (17 > actualTimeHour) {
                return DayTime.AFTERNOON.toString().toLowerCase();
            }
            return DayTime.EVENING.toString().toLowerCase();
        };

        Consumer<String> greet = (name) -> System.out.println("Good " + getDayTime.get() + ", " + name);

        greet.accept("John");
    }
}
