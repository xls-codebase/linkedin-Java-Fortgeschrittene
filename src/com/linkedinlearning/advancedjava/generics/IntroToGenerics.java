package com.linkedinlearning.advancedjava.generics;

import java.util.ArrayList;
import java.util.List;

public class IntroToGenerics {

    record Book(String title, String author) {}

    // A generic class named Box
    static class Box<T> {
        // T stands for "Type"
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    public static void main(String[] args) {
        // Create a list to store books
        List<Book> bookList = new ArrayList<>();

        // Add books to the list
        bookList.add(new Book("Effective Java", "Joshua Bloch"));
        bookList.add(new Book("Java Concurrency in Practice", "Brian Goetz"));
        bookList.add(new Book("Clean Code", "Robert C. Martin"));

        // Display the details of each book
        for (Book book : bookList) {
            System.out.println(book);
        }

        // Instantiate a Box for Integers
        Box<Integer> integerBox = new Box<>();

        // Set a value in this box
        integerBox.set(10);

        // Retrieve and print the value from the box
        System.out.println(integerBox.get());

        // Instantiate a Box for Strings
        Box<String> stringBox = new Box<>();

        // Set a value in this box
        stringBox.set("Hello Generics");

        // Retrieve and print the value from the box
        System.out.println(stringBox.get());

        // Instantiate a Box for Books
        Box<Book> bookBox = new Box<>();
        bookBox.set(new Book("Effective Java", "Joshua Bloch"));
        System.out.println(bookBox.get());

    }

}
