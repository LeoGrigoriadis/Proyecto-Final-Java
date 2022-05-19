package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CoinRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Object> findAll(){
        //String url = "http://rest.coinapi.io/v1/assets/?apikey=CB534D2D-8155-4886-83CC-DBED35CD1950";
        String url = "http://rest.coinapi.io/v1/assets/BTC?apikey=CB534D2D-8155-4886-83CC-DBED35CD1950";
        
        ArrayList<Object> coins = new ArrayList<>();

        coins = rt.getForObject(url,ArrayList.class);


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
