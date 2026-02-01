package com.example.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class ServerClientService {

    private final RestClient restClient;

    @Value("${server.service.url:http://localhost:8081}")
    private String serverBaseUrl;

    public ServerClientService() {
        this.restClient = RestClient.create();
    }

    public String connectToServer() {
        try {
            String response = restClient.get()
                    .uri(serverBaseUrl + "/server/connect")
                    .retrieve()
                    .body(String.class);
            return "Client received: " + response;
        } catch (RestClientException e) {
            return "Connection failed: " + e.getMessage();
        }
    }
}