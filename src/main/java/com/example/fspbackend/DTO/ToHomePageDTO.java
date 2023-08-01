package com.example.fspbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ToHomePageDTO {
    //private String address;
    private String postId;
    private String title;
    private String place;
    private String time;
    private String people;
    private String shopImg;
}
