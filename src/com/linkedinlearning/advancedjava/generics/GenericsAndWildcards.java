package com.linkedinlearning.advancedjava.generics;

import java.util.Arrays;
import java.util.List;

public class GenericsAndWildcards {

    public static class Box<T> {
        private T t;

        public Box(T t) {
            this.t = t;
        }

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "t=" + t +
                    '}';
        }
    }

    // Method with an unbounded wildcard
    // It can read from a list of Box of any type
    public static void printBoxes(List<Box<?>> boxes) {
        for (Box<?> box : boxes) {
            System.out.println(box);
        }
    }

    // Method with an upper bounded wildcard
    // It can read from a list of Box of Number or any subclass of Number
    public static void printNumberBoxes(List<Box<? extends Number>> boxes) {
        for (Box<? extends Number> box : boxes) {
            System.out.println(box);
        }
    }

    public static void main(String[] args) {
        // Using the unbounded wildcard
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> integerBox = new Box<>(123);
        List<Box<?>> mixedBoxes = Arrays.asList(stringBox, integerBox);
        printBoxes(mixedBoxes);

        // Using the upper bounded wildcard
        Box<Integer> intBox = new Box<>(456);
        Box<Double> doubleBox = new Box<>(3.14);
        List<Box<? extends Number>> numberBoxes = Arrays.asList(intBox, doubleBox);
        printNumberBoxes(numberBoxes);
    }

}
