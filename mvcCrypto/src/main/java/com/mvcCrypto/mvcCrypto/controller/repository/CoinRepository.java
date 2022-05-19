package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CoinRepository {

    public ArrayList<Coin> findAll(){
        String url = "http://rest.coinapi.io/v1/assets/?apikey=CB534D2D-8155-4886-83CC-DBED35CD1950";
        RestTemplate rt = new RestTemplate();
        ArrayList<Coin> coins = new ArrayList<>();
        coins = rt.getForObject(url, ArrayList.class);

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
