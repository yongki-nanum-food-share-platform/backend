package com.example.fspbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
    private String title;
    private String content;
    private String menu;
    private String time;
    private String place;
    private String people;
}
