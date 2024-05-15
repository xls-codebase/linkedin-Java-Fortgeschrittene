package com.linkedinlearning.advancedjava.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateAndBipredicate {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, 3, -1, 4, -2, 7);

        // Predicate to check if a number is positive
        Predicate<Integer> isPositive = number -> number > 0;

        // Using Stream with Predicate to filter positive numbers
        List<Integer> positiveNumbers = numbers.stream()
                .filter(isPositive)
                .toList();

        System.out.println("Positive numbers: " + positiveNumbers);

        // BiPredicate to check if the sum of two numbers is even
        BiPredicate<Integer, Integer> isSumEven = (num1, num2) -> (num1 + num2) % 2 == 0;

        // Conceptually check pairs (not directly stream-related but illustrates BiPredicate use)
        System.out.println("Is the sum of 4 and 5 even? " + isSumEven.test(4, 5));
        System.out.println("Is the sum of 7 and 1 even? " + isSumEven.test(7, 1));


        // We can also combine multiple predicates using the and(), or(), and negate() methods

        // Predicate to check if a number is greater than 3
        Predicate<Integer> isGreaterThan3 = n -> n > 3;

        // Predicate to check if a number is even
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Combine the two predicates using Predicate.and()
        Predicate<Integer> isGreaterThan3AndEven = isGreaterThan3.and(isEven);

        // Use the combined predicate to filter the list
        List<Integer> filteredNumbers = numbers.stream()
                .filter(isGreaterThan3AndEven)
                .toList();

        System.out.println("Numbers greater than 3 and even: " + filteredNumbers);
    }

}
