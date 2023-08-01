package com.example.fspbackend.DAO;

import com.example.fspbackend.Exception.MemberNotFoundException;
import com.example.fspbackend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    public User selectUser(String id) throws MemberNotFoundException {
        Query query = new Query(Criteria.where("userId").is(id));
        List<User> userList = mongoTemplate.find(query, User.class);

        if(userList.size() <= 0) {
            throw new MemberNotFoundException();
        }

        return userList.get(0);
    }
}