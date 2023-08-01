package com.example.fspbackend.Controller;

import com.example.fspbackend.DTO.ToUserInfoDTO;
import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.Service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/api/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public ToUserInfoDTO info(@RequestHeader(value = "Authorization") String token) throws MemberNotFoundException {
       ToUserInfoDTO toUserInfoDTO =  userInfoService.selectUserInfo(token);

       return toUserInfoDTO;
    }
}