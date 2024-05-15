package com.linkedinlearning.advancedjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutputIntro {

    public static void main(String[] args) {
        String filePath = "example.txt";
        String message = "Hello, Java I/O!";

        // Write a message to a file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(message);
            System.out.println("Message written to file: " + message);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Read the message from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String readMessage = reader.readLine(); // Assuming the message is a single line
            System.out.println("Message read from file: " + readMessage);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

}
