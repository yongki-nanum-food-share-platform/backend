package com.example.fspbackend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
public class Post {
    @Id
    private String postID;
    private String postTitle;
    private String postContent;
    private String postAuth;
    private String shareMenu;
    private String shareTime;
    private String sharePlace;
    private String sharePeople;
    private String shareShop;
    private String tip;

    public String getPostID() {
        return postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostAuth() {
        return postAuth;
    }

    public void setPostAuth(String postAuth) {
        this.postAuth = postAuth;
    }

    public String getShareMenu() {
        return shareMenu;
    }

    public void setShareMenu(String shareMenu) {
        this.shareMenu = shareMenu;
    }

    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
    }

    public String getSharePlace() {
        return sharePlace;
    }

    public void setSharePlace(String sharePlace) {
        this.sharePlace = sharePlace;
    }

    public String getSharePeople() {
        return sharePeople;
    }

    public void setSharePeople(String sharePeople) {
        this.sharePeople = sharePeople;
    }

    public String getShareShop() {
        return shareShop;
    }

    public void setShareShop(String shareShop) {
        this.shareShop = shareShop;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
