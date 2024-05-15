package com.linkedinlearning.advancedjava.generics;

public class TypeErasure {

    static class Box<T> {
        private T content;

        public Box(T content) {
            this.content = content;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>(123);
        Box<String> stringBox = new Box<>("Hello");

        if (integerBox.getClass().equals(stringBox.getClass())) {
            System.out.println("The runtime types of integerBox and stringBox are the same.");
        } else {
            System.out.println("The runtime types of integerBox and stringBox are different.");
        }

        // Attempting to determine the generic type at runtime
        System.out.println("The type of Box is: " + integerBox.getClass().getName());
    }

}
