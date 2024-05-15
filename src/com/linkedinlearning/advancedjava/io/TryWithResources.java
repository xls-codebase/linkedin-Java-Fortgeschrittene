package com.linkedinlearning.advancedjava.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        String filePath = "output.txt";
        String content = "Hello, World! This is a message written to a file.";

        // Using try-with-resources to ensure the BufferedWriter is closed
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

}
