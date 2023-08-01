package com.example.fspbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatListDTO {
    private String title;
    private String lastMsg;
    private String place;
}
