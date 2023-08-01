package com.example.fspbackend.DAO;

import com.example.fspbackend.Model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDAO {
    @Autowired
    MongoTemplate mongoTemplate;

    public Shop selectShop(String shopName) {
        Query query = new Query(Criteria.where("shopName").is(shopName));
        List<Shop> shopList = mongoTemplate.find(query, Shop.class);

        return shopList.get(0);
    }
}
