package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class CoinExternoRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Object> findAll(){

       // String url = "http://rest.coinapi.io/v1/assets/?apikey=CB534D2D-8155-4886-83CC-DBED35CD1950";
        String xx = "BTN";
        String url = "http://rest.coinapi.io/v1/assets/"+ xx +"?apikey=71E090DE-46AB-4E0A-ACEC-031136EF98A3";
        String url2 = "http://rest.coinapi.io/v1/assets/USD?apikey=71E090DE-46AB-4E0A-ACEC-031136EF98A3";
        System.out.println(url);
       ArrayList<Object> coins = new ArrayList<>();
        //ArrayList<Object> coins2 = new ArrayList<>();
        //Object a= new Object();

       coins = rt.getForObject(url,ArrayList.class);
        //coins.add(rt.getForObject(url2,Object.class));






        return coins;
    }



    public Object getByName(String name){
        String url = "http://rest.coinapi.io/v1/assets/"+name+"?apikey=71E090DE-46AB-4E0A-ACEC-031136EF98A3";

        RestTemplate rt = new RestTemplate();

        Object user;
        user = rt.getForObject(url, Object.class);
        return user;
    }

}
