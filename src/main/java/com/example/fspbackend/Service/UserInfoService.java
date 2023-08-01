package com.example.fspbackend.Service;

import com.example.fspbackend.DAO.PostDAO;
import com.example.fspbackend.DAO.UserDAO;
import com.example.fspbackend.DTO.ToUserInfoDTO;
import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.Model.Post;
import com.example.fspbackend.Model.User;
import com.example.fspbackend.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public ToUserInfoDTO selectUserInfo(String token) throws MemberNotFoundException {
        User user = userDAO.selectUser(jwtTokenProvider.getUserIdFromJwt(token));
        List<Post> post = postDAO.selectPostTitle(user.getNickname());

        String[] postTitle = new String[post.size()];

        for(int i=0; i<postTitle.length; i++) {
            postTitle[i] = post.get(i).getPostTitle();
        }

        ToUserInfoDTO toUserInfoDTO = new ToUserInfoDTO(user.getNickname(), user.getUserId(), postTitle);

        return toUserInfoDTO;
    }
}
