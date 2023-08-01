package com.example.fspbackend.Controller;

import com.example.fspbackend.DTO.PostDTO;
import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.Service.WritePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "rest/api/post")
@CrossOrigin(origins = "http://localhost:8080")
public class WritePostController {
    @Autowired
    private WritePostService writePostService;

    @PostMapping
    public void post(@RequestHeader(value = "Authorization") String token, @RequestBody PostDTO postDTO) throws MemberNotFoundException {
        writePostService.writePost(token, postDTO);
    }
}
