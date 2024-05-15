package com.linkedinlearning.advancedjava.functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperator {

    public static void main(String[] args) {
        // UnaryOperator to negate a number
        UnaryOperator<Integer> negate = x -> -x;

        // Apply the UnaryOperator
        int result = negate.apply(5);
        System.out.println("Negation of 5: " + result);

        // BinaryOperator to find the maximum of two numbers
        BinaryOperator<Integer> max = (x, y) -> x > y ? x : y;

        // Apply the BinaryOperator
        int maximum = max.apply(5, 3);
        System.out.println("Maximum of 5 and 3: " + maximum);


        BiFunction<Integer, Integer, Integer> maxAndNegateFunction = max.andThen(negate);
        int maxAndNegate = maxAndNegateFunction.apply(5, 3);
        System.out.println(maxAndNegate);

    }

}
