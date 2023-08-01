package com.example.fspbackend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/api/chat")
@CrossOrigin(origins = "http://localhost:8080")
public class ChatController {
    /*@GetMapping
    public viewDTO post() {
        return new viewDTO();
    }*/
}