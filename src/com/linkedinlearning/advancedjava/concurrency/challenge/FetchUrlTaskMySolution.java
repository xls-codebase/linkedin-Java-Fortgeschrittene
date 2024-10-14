package com.linkedinlearning.advancedjava.concurrency.challenge;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchUrlTaskMySolution implements Runnable {
    private final URI uri;
    private final HttpClient httpClient;
    private final int start = 3;
    private final int trimLength = start + 10;

    public FetchUrlTaskMySolution(URI uri) {
        this.uri = uri;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String fetch(URI uri) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    @Override
    public void run() {
        String data;
        try {
            data = fetch(uri);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data.substring(start, start + trimLength));
    }

    public static void main(String[] args) {
        int count = 10;
        ExecutorService executor = Executors.newFixedThreadPool(count);

        for (int i = 1; i <= count; i++) {
            URI uri = URI.create("https://jsonplaceholder.typicode.com" + "/users/" + i);
            executor.submit(new FetchUrlTaskMySolution(uri));
        }
        executor.shutdown();
    }
}
