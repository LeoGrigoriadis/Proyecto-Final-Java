package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.controller.repository.CoinRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinExternoService {

    @Autowired
    private CoinExternoRepository cr;


    public Coin getAll() {
        /*List<String> list= Arrays.asList("btc", "xrp", "eth");
        ArrayList<Coin> coins=new ArrayList<>();
        for (String coin: list){
            coins.add(cr.findCot(coin));
        }
        return coins;
    */

        return cr.findAll();
    }



   /* public Coin getByName(String name)
    {
        return cr.getByName(name);
    }*/
}

