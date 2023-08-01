package com.example.fspbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ToUserInfoDTO {
    private String nickname;
    private String userId;
    private String[] postTitle;
}
