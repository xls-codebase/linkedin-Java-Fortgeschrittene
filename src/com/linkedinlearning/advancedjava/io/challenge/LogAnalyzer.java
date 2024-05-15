package com.linkedinlearning.advancedjava.io.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LogAnalyzer {
    public static void main(String[] args) {
        String inputFilePath = "logfile.txt";
        String outputFilePath = "log_summary.txt";
        Map<String, Integer> logCounts = new HashMap<>();

        // Read and process the log file
        System.out.println("Reading log file: " + inputFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String logLevel = line.substring(1, line.indexOf("]")); // Extract log level
                logCounts.merge(logLevel, 1, Integer::sum); // Increment count for this log level
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
            return;
        }

        // Write the log level counts to the summary report
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : logCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Log summary report written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing summary report: " + e.getMessage());
        }
    }
}
