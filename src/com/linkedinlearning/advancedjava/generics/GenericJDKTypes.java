package com.linkedinlearning.advancedjava.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericJDKTypes {

    public static void main(String[] args) {
        // Collection Example: Using ArrayList
        List<String> bookTitles = new ArrayList<>();
        bookTitles.add("Effective Java");
        bookTitles.add("Java Concurrency in Practice");
        bookTitles.add("Clean Code");

        // Stream Example: Filtering Collection
        List<String> filteredTitles = bookTitles.stream()
                .filter(title -> title.startsWith("Effective"))
                .toList();
        System.out.println("Filtered Titles: " + filteredTitles);

        // Optional example
        Optional<String> maybeTitle = bookTitles.stream()
                .filter(title -> title.contains("Java"))
                .findFirst();

        maybeTitle.ifPresent(title -> System.out.println("Found title: " + title));
    }

}
