package com.example.fspbackend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fspbackend.DTO.ChatListDTO;

@RestController
@RequestMapping(value = "rest/api/chatlist")
@CrossOrigin(origins = "http://localhost:8080")
public class ChatListController {
    @GetMapping
    public ChatListDTO chatlist() {
        return new ChatListDTO("title", "lastMsg", "place");
    }
}
