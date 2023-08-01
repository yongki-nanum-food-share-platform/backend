package com.example.fspbackend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shop")
public class Shop {
    @Id
    private String shopId;
    private String shopName;
    private String shopMenu;
    private String shopAddress;
    private String shopImg;
    private String shopTip;

    public String getShopTip() {
        return shopTip;
    }

    public void setShopTip(String shopTip) {
        this.shopTip = shopTip;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopMenu() {
        return shopMenu;
    }

    public void setShopMenu(String shopMenu) {
        this.shopMenu = shopMenu;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }
}
