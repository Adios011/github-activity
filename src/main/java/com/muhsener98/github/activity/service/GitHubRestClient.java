package com.muhsener98.github.activity.service;

import com.muhsener98.github.activity.dto.GitHubEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GitHubRestClient {

    private final String URI = "https://api.github.com/users/<username>/events";

    public HttpResponse<String> fetchEventsOf(String username) {
        String uri = URI.replace("<username>", username);
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            return httpClient.send(httpRequest , HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
