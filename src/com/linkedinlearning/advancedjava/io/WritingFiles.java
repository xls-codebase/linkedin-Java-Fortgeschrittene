package com.linkedinlearning.advancedjava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WritingFiles {

    public static void main(String[] args) {
        String filePath = "output.txt";
        List<String> lines = Arrays.asList("Hello, Java File I/O!", "This is another line in the file.");

        try {
            // Write lines to a file
            Files.write(Paths.get(filePath), lines);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
