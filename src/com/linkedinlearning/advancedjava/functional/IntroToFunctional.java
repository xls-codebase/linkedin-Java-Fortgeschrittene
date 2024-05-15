package com.linkedinlearning.advancedjava.functional;

public class IntroToFunctional {

    @FunctionalInterface
    public interface ArithmeticOperation {
        int operate(int a, int b);
    }

    public static void main(String[] args) {
        // Using lambda expression for addition
        ArithmeticOperation addition = (a, b) -> a + b;
        System.out.println("Addition of 5 and 3: " + addition.operate(5, 3));

        // Using lambda expression for subtraction
        ArithmeticOperation subtraction = (a, b) -> a - b;
        System.out.println("Subtraction of 5 and 3: " + subtraction.operate(5, 3));
    }

}
