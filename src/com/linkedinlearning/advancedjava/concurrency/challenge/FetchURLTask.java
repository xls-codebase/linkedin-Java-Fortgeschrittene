package com.linkedinlearning.advancedjava.concurrency.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchURLTask implements Runnable {
    private final String url;

    public FetchURLTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // For demonstration, return the first 100 characters of the response body
        String body = response.body().substring(0, Math.min(100, response.body().length()));
        System.out.println("Fetched " + url + " - " + body);
    }

    public static void main(String[] args) throws Exception {
        String[] urls = {
                "http://example.com",
                "http://example.org",
                "https://api.github.com"
        };

        ExecutorService executor = Executors.newFixedThreadPool(urls.length); // Create a thread pool

        for (String url : urls) {
            executor.submit(new FetchURLTask(url));
        }

        executor.shutdown(); // Shutdown the executor
    }
}

