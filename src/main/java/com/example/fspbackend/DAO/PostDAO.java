package com.example.fspbackend.DAO;

import com.example.fspbackend.Exception.PostNotFoundException;
import com.example.fspbackend.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Post> selectAllPost() throws PostNotFoundException {
        Query query = new Query();
        List<Post> postList = mongoTemplate.find(query, Post.class);
        if(postList.size() <= 0) {
            System.out.println("Not exist post!!");
            throw new PostNotFoundException();
        }

        return postList;
    }

    public Post selectPost(String postId) throws PostNotFoundException {
        Query query = new Query(Criteria.where("_id").is(postId));
        List<Post> post = mongoTemplate.find(query, Post.class);

        if(post.size() <= 0) {
            System.out.println("Not exist Post");
            throw new PostNotFoundException();
        }

        return post.get(0);
    }

    public List<Post> selectPostTitle(String postAuth) {
        Query query = new Query(Criteria.where("postAuth").is(postAuth));
        List<Post> postList = mongoTemplate.find(query, Post.class);

        return postList;
    }

    public void postInsert(Post post) {
        mongoTemplate.insert(post, "post");
    }
}