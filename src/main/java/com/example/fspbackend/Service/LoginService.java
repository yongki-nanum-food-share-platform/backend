package com.example.fspbackend.Service;

import com.example.fspbackend.Exception.LoginFailedException;
import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.DTO.LoginDTO;
import com.example.fspbackend.Model.User;
import com.example.fspbackend.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserDAO userDAO;

    public void loginCheck(LoginDTO login) throws MemberNotFoundException, LoginFailedException {
        User user = userDAO.selectUser(login.getUserId());

        if(user == null) {
            System.out.println("Not exist User!!");
            throw new MemberNotFoundException();
        }

        if(login.getPassword().equals(user.getPassword())) {
            System.out.println("Login Success!!");
        } else {
            System.out.println("Login Failed");
            throw new LoginFailedException();
        }
    }
}