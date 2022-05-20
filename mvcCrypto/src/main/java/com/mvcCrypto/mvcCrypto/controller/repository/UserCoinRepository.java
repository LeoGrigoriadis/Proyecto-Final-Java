package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class UserCoinRepository{

    @Autowired
    private RestTemplate rt;

    public ArrayList<User_Coin> findAllById(int id){

        String url = "http://localhost:8090/api/UserCoin/idUser/"+id;
        ArrayList<User_Coin> user_coins= rt.getForObject(url,ArrayList.class);
        return user_coins;
    }

}
