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


    public ArrayList<Coin> getAll() {
        ArrayList<Coin> coins= new ArrayList<>();
        coins.add(cr.findBtc());
        coins.add(cr.findXrp());
        coins.add(cr.findUsdt());
        coins.add(cr.findUsdc());
        return coins;
    }

    public double getOne(String coin){
        return cr.findById(coin);
    }

   /* public Coin getByName(String name)
    {
        return cr.getByName(name);
    }*/
}

