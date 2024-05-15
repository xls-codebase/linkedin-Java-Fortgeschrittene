package com.linkedinlearning.advancedjava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {

    public static void main(String[] args) {
        String directoryPath = "src";

        try {
            // Use Files.walk to get a stream of paths
            System.out.println("Files in directory: " + directoryPath);
            Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile) // Filter to get only files, excluding directories
                    .forEach(System.out::println); // Print each file path

            System.out.println("\nDirectories in directory: " + directoryPath);
            Files.walk(Paths.get(directoryPath))
                    .filter(Files::isDirectory) // Filter to get only files, excluding directories
                    .forEach(System.out::println); // Print each file path
        } catch (IOException e) {
            System.err.println("An error occurred while listing files: " + e.getMessage());
        }
    }

}
