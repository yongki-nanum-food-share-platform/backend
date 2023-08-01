package com.example.fspbackend.Controller;

import com.example.fspbackend.DTO.ToHomePageDTO;
import com.example.fspbackend.Exception.PostNotFoundException;
import com.example.fspbackend.Exception.ToHomePageDTOException;
import com.example.fspbackend.Service.HomePageService;
import com.example.fspbackend.jwt.JwtTokenDTO;
import com.example.fspbackend.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;

@RestController
@RequestMapping(value = "rest/api/home")
@CrossOrigin(origins = "http://localhost:8080")
public class HomePageController {
    @Autowired
    private HomePageService homeSvc;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping
    public List<ToHomePageDTO> home(@RequestHeader(value = "Authorization") String token) throws PostNotFoundException, ToHomePageDTOException {
        return homeSvc.homePageLoad();
    }
}