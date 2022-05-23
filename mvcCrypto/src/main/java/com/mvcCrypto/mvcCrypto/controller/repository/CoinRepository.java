package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CoinRepository {

    @Autowired
    private RestTemplate rt;

    public Coin findCot(String var){
        String url = "https://criptoya.com/api/bitex/"+var+"/usd/1";

        Coin coins = rt.getForObject(url,Coin.class);
        System.out.println(coins);

        return coins;
    }



    public Coin getByName(String name){
        String url = "http://rest.coinapi.io/v1/assets/"+name+"?apikey=CB534D2D-8155-4886-83CC-DBED35CD1950";

        RestTemplate rt = new RestTemplate();

        Coin user;
        user = rt.getForObject(url, Coin.class);
        return user;
    }

}
