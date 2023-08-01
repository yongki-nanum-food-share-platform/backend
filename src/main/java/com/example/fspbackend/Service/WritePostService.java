package com.example.fspbackend.Service;

import com.example.fspbackend.DAO.PostDAO;
import com.example.fspbackend.DAO.UserDAO;
import com.example.fspbackend.DTO.PostDTO;
import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.Model.Post;
import com.example.fspbackend.Model.Shop;
import com.example.fspbackend.Model.User;
import com.example.fspbackend.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WritePostService {
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public void writePost(String token, PostDTO postDTO) throws MemberNotFoundException {
        User user = userDAO.selectUser(jwtTokenProvider.getUserIdFromJwt(token));
        Post post = new Post();
        Shop shop = new Shop();


        post.setPostAuth(user.getNickname());
        post.setPostContent(postDTO.getContent());
        post.setShareMenu(postDTO.getMenu());
        post.setSharePeople(postDTO.getPeople());
        post.setPostTitle(postDTO.getTitle());
        post.setShareTime(postDTO.getTime());
        post.setSharePlace(postDTO.getPlace());
        post.setShareShop("굽네치킨");
        post.setTip("2000원");

        postDAO.postInsert(post);
    }
}
