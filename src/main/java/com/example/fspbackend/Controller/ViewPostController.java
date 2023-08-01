package com.example.fspbackend.Controller;

import com.example.fspbackend.DTO.ViewDTO;
import com.example.fspbackend.DTO.testDTO;
import com.example.fspbackend.Exception.PostNotFoundException;
import com.example.fspbackend.Service.ViewPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "rest/api/view")
public class ViewPostController {
    @Autowired
    private ViewPostService viewSvc;

    @PostMapping
    public ViewDTO view(@RequestBody testDTO test) throws PostNotFoundException {
        return viewSvc.view(test.getPostId());
    }
}