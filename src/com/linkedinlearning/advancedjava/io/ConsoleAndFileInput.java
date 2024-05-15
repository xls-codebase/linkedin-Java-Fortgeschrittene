package com.linkedinlearning.advancedjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleAndFileInput {

    public static void main(String[] args) throws IOException {
        // Create a Scanner object for console input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the name of the file to read
        System.out.println("Enter the name of the file to read:");
        String fileName = scanner.nextLine();

        // Now, read from the specified file
        System.out.println("Reading from file: " + fileName);

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();

        // Close the scanner
        scanner.close();
    }

}
