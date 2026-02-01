package com.example.client.controller;

import com.example.client.service.ServerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ServerClientService serverClientService;

    @GetMapping("/checkConnection")
    public String getServiceConnectionStatus() {
        return serverClientService.connectToServer();
    }
}