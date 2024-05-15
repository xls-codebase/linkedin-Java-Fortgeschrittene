package com.linkedinlearning.advancedjava.generics;

public class CustomGenericTypes {

    static class Pair<T, U> {
        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public void setSecond(U second) {
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        System.out.println("First: " + pair.getFirst());  // Output: Hello
        System.out.println("Second: " + pair.getSecond());  // Output: 123
    }

}
