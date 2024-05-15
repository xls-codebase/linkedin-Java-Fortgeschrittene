package com.linkedinlearning.advancedjava.generics;

public class GenericMethods {
    public static <T> boolean contains(T[] array, T value) {
        for (T element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Python", "C++"};

        System.out.println(contains(intArray, 3));  // Output: true
        System.out.println(contains(strArray, "Java"));  // Output: true
        System.out.println(contains(strArray, "Ruby"));  // Output: false
    }
}
