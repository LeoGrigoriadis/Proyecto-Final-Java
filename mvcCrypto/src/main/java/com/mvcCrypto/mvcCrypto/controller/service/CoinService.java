package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinService {

    @Autowired
    private CoinRepository cr;


    public ArrayList<Coin> getAll() {
        List<String> list= Arrays.asList("btc", "xrp", "eth");
        ArrayList<Coin> coins=new ArrayList<>();
        for (String coin: list){
            coins.add(cr.findCot(coin));
        }
        return coins;
    }


   /* public Coin getByName(String name)
    {
        return cr.getByName(name);
    }*/
}
