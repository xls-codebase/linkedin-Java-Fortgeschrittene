package com.linkedinlearning.advancedjava.io.challenge;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzerMySolution {
    public static class LogAnalyzer {
        private Map<String, Integer> readLogTypes(String fileName) {
            Map<String, Integer> countedLogEntries = new HashMap<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                String line;
                Pattern pattern = Pattern.compile("^\\[([A-Z]+)]");
                while ((line = bufferedReader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String logLevel = matcher.group(1);
                        countedLogEntries.merge(logLevel, 1, Integer::sum);
                    }
                }
            } catch (IOException e) {
                System.err.println("An error occurred while reading file: " + e.getMessage());
            }
            return countedLogEntries;
        }

        private void writeToFile(Map<String, Integer> countedLogEntries, String outputFileName) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName))) {
                countedLogEntries.forEach((k, v) -> {
                    try {
                        bufferedWriter.write(v + " " + k + "-entries.");
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        System.err.println("An error occurred while writing to file: " + e.getMessage());
                    }
                });
            } catch (IOException e) {
                System.err.println("An error occurred while writing to file: " + e.getMessage());
            }
        }

        public void process(String inputFile, String outputFile) {
            Map<String, Integer> countedLogEntries = readLogTypes(inputFile);
            writeToFile(countedLogEntries, outputFile);
        }
    }

    public static void main(String[] args) {
        String logFile = "logfile.txt";
        String outputFile = "output.txt";

        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.process(logFile, outputFile);

    }
}
