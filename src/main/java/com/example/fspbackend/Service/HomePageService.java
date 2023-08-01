package com.example.fspbackend.Service;

import com.example.fspbackend.DAO.PostDAO;
import com.example.fspbackend.DAO.ShopDAO;
import com.example.fspbackend.DAO.UserDAO;
import com.example.fspbackend.DTO.ToHomePageDTO;
import com.example.fspbackend.Exception.PostNotFoundException;
import com.example.fspbackend.Exception.ToHomePageDTOException;
import com.example.fspbackend.Model.Post;
import com.example.fspbackend.Model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomePageService {
    /*@Autowired
    private UserDAO userDAO;*/
    @Autowired
    private ShopDAO shopDAO;
    @Autowired
    private PostDAO postDAO;

    public List<ToHomePageDTO> homePageLoad() throws PostNotFoundException, ToHomePageDTOException {
        //
        //유저의 주소 로드 구현//
        //
        //User user = userDAO(userId);
        //DTO에 주소 set
        List<Post> postList = postDAO.selectAllPost();
        List<ToHomePageDTO> toHomePageDTO = new ArrayList<>(postList.size());

        for(int i=0; i<postList.size(); i++) {
            //Shop 이미지 로드를 위한 샵 객체 로드
            Shop shop = shopDAO.selectShop(postList.get(i).getShareShop());
            //프론트로 전송할 DTO객체를 초기화 함
            ToHomePageDTO homePageDTO = new ToHomePageDTO(
                    postList.get(i).getPostID(), postList.get(i).getPostTitle(), postList.get(i).getSharePlace(),
                    postList.get(i).getShareTime(), postList.get(i).getSharePeople(), shop.getShopImg());
            //초기화 된 DTO 객체를 리스트화 함
            toHomePageDTO.add(homePageDTO);
        }

        if(toHomePageDTO.size() <= 0) {
            System.out.println("Do not get ToHomePageDTO");

            throw new ToHomePageDTOException();
        }

        return toHomePageDTO;
    }
}
