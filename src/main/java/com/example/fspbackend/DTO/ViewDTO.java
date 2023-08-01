package com.example.fspbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ViewDTO {
    private String title;
    private String content;
    private String menu;
    private String time;
    private String place;
    private String people;
    private String store;
    private String tip;
}
